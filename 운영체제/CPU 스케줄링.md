### CPU 스케줄링

CPU가 하나의 프로세스 작업이 끝나면 다음 프로세스 작업을 수행해야 한다. 이때 어떤 프로세스를 다음에 처리할 지 선택하는 알고리즘을 CPU Scheduling 알고리즘이라고 한다. 따라서 상황에 맞게 CPU를 어떤 프로세스에 배정하여 효율적으로 처리하는가가 관건이다.

- 조건 : 오버헤드↓ /사용률↑ / 기아현상↓
- 목표
    - Batch System : 가능한 많은 일을 수행 (처리량이 중요)
    - Interactive System : 빠른 응답 시간, 적은 대기 시간
    - Real-time System : 기한 맞추기
- 척도 :
    - Response Time : 작업이 처음 실행되기까지 걸린 시간
    - Turnaround Time : 실행 시간과 대기 시간을 모두 합한 시간으로 작업이 완료될 때 까지 걸린 시간


### Preemptive vs Non-Preemptive

1) Preemptive(선점)

- 프로세스가 CPU를 점유하고 있는 동안 I/O나 인터럽트가 발생하지 않았음에도 다른 프로세스가 해당 CPU를 강제로 점유할 수 있다. 
- 즉, 프로세스가 정상적으로 수행중인 동안 다른 프로세스가 CPU를 강제로 점유하여 실행할 수 있다.



2) Non-Preemptive(비선점)

- 한 프로세스가 CPU를 점유했다면 I/O나 인터럽트 발생 또는 프로세스가 종료될 때까지 다른 프로세스가 CPU를 점유하지 못하는 것이다. 

  
> ### 참고) 프로세스 상태
> ![download (5)](https://user-images.githubusercontent.com/13609011/91695344-f2dfae80-eba8-11ea-9a9b-702192316170.jpeg)
> - 비선점 스케줄링 : `Interrupt`, `Scheduler Dispatch`
> - 선점 스케줄링 : `I/O or Event Wait`  
>  
> **프로세스 상태 전이**
> - 승인 (Admitted) : 프로세스 생성이 가능하여 승인됨.
> - 스케줄러 디스패치 (Scheduler Dispatch) : 준비 상태에 있는 프로세스 중 하나를 선택하여 실행시키는 것.
> - 인터럽트 (Interrupt) : 예외, 입출력, 이벤트 등이 발생하여 현재 실행 중인 프로세스를 준비 상태로 바꾸고, 해당 작업을 먼저 처리하는 것.
> - 입출력 또는 이벤트 대기 (I/O or Event wait) : 실행 중인 프로세스가 입출력이나 이벤트를 처리해야 하는 경우, 입출력/이벤트가 모두 끝날 때까지 대기 상태로 만드는 것.
> - 입출력 또는 이벤트 완료 (I/O or Event Completion) : 입출력/이벤트가 끝난 프로세스를 준비 상태로 전환하여 스케줄러에 의해 선택될 수 있도록 만드는 것.

### 선점형 스케줄링

1) SRT(Shortest Remaining Time) 스케줄링

- 짧은 시간 순서대로 프로세스를 수행한다.
- 현재 CPU에서 실행 중인 프로세스의 남은 CPU 버스트 시간보다 더 짧은 CPU 버스트 시간을 가지는 프로세스가 도착하면 CPU가 선점된다.

2) Round Robin 스케줄링

- 시분할 시스템의 성질을 활용한 방법
- 일정 시간을 정하여 하나의 프로세스가 이 시간동안 수행하고 다시 대기 상태로 돌아간다.
- 그리고 다음 프로세스 역시 같은 시간동안 수행한 후, 대기한다. 이러한 작업을 모든 프로세스가 돌아가면서 진행하며, 마지막 프로세스가 끝나면 다시 처음 프로세스로 돌아와서 작업을 반복한다.
- 일정 시간을 Time Quantum(Time Slice)라고 부른다. 일반적으로 10 ~ 100msec 사이의 범위를 갖는다.
- 한 프로세스가 종료되기 전에 time quantum이 끝나면 다른 프로세스에게 CPU를 넘겨주기 때문에 선점형 스케줄링의 대표적인 예시다.
- Time Quantum이 크면 FCFS와 같게 되고, 작으면 잦은 Context Switching으로 오버헤드가 증가한다.

3) Multi-level Queue(다단계 큐) 스케줄링
- 우선 순위마다 준비 큐(Ready Queu)를 형성하고 항상 가장 높은 우선순위 큐의 프로세스에 CPU를 할당하는 방식이다.
- 우선 순위가 낮은 큐에서 작업 실행 중이더라도 상위 큐에 프로세스가 도착하면 CPU를 선점하기에 선점형 스케줄링이다.
- OS의 실행방식에 따라 각 큐의 우선순위가 달라지고, 각 큐마다 다른 규칙을 지정할 수도 있다.
- 큐들 간 프로세스 이동이 불가능하기에 스케줄링 부담이 적지만 유연성이 떨어지며, 우선순위가 낮은 프로세스는 기아 현상이 발생할 수 있다.
![img](https://user-images.githubusercontent.com/34755287/53879673-5e979880-4052-11e9-9f9b-e8bfec7c9be6.png)

4) Multi-level feedback Queue(다단계 피드백 큐) 스케줄링
- 다단계 큐와 유사하게 여러 큐를 이용한다.
- 프로세스 생성 시 가장 높은 우선 순위 준비 큐에 등록되며 FIFO 순서로 CPU를 할당 받아 실행되는데 해당 큐의 Time Quantum이 끝나면 다음 단계의 준비 큐로 들어가는 방식이다.
- 단계가 내려갈수록 Time Quantum이 증가하며 가장 하위 큐는 FCFS이다.
- 큐의 수, 각 큐의 처리 방식, 단계 격상(기아 상태 방지)/격하 시기, 처음 들어갈 큐 선정 등 복잡한 판단을 요구한다.
![Untitled](https://user-images.githubusercontent.com/13609011/91695480-2a4e5b00-eba9-11ea-8dbf-390bf0a73c10.png)



### 비선점형 스케줄링

1) FCFS(First Come First Server)

- 준비 큐에 먼저 도착한 프로세스가 먼저 CPU를 점유하는 방식이다.
- CPU를 할당받으면 CPU 버스트가 완료될 때까지 CPU를 반환하지 않으며, 할당되었던 CPU가 반환될 때만 스케줄링이 이루어진다.
- 실행 시간이 짧은 게 뒤로 가면 평균 대기 시간이 길어짐
> 참고  
> <img src="https://user-images.githubusercontent.com/33534771/89703489-500b8a00-d986-11ea-9b6c-27cca4ea1016.png" width="300" height="300"/>
>
> ![img](https://user-images.githubusercontent.com/34755287/53879661-5d666b80-4052-11e9-8453-bad918a563ef.png)
> 표는 3개의 프로세스와 각 프로세스가 CPU를 사용한 시간(Burst Time)을 나타낸다.  
> 이를 간트 차트로 표현하면 그림과 같다. (도착 시간은 모두 0초라고 가정한다.)  
> 평균 대기 시간은 아래와 같다.  
> - Average Waiting Time = 0 + 24 + 27 / 3 = 17msec  
> 만약, 프로세스가 들어온 순서가 P3, P2, P1이라면 간트 차트는 아래와 같이 바뀐다.
> ![img](https://user-images.githubusercontent.com/34755287/53879665-5d666b80-4052-11e9-8ad5-8639b73b13ac.png)
> - Average Waiting Time = 3 + 6 + 0 / 3 = 3msec
> 두 경우에서 모든 프로세스가 끝난 시간은 30msec로 같지만, 평균 대기 시간으로 봤을 때는 위의 예제는 17msec이고 아래는 3msec로 차이가 난다. **즉, 들어온 순서로 수행한다고 해서 반드시 효율적인 것은 아니다.**
> 위의 예제처럼 `P1, P2, P3` 순서로 들어온 경우를 **Convoy Effect** 라고 한다. 
> 이는 CPU 시간을 오래 사용하는 프로세스가 먼저 수행되는 동안 나머지 프로세스들은 그만큼 오래 기다리는 것을 뜻한다. P1이 수행되는 동안 P2, P3는 오래 기다리게 된다. 
> 단점
> - Convoy Effect 발생 : 소요 시간이 긴 프로세스가 짧은 프로세스보다 먼저 도착해서 뒤에 프로세스들이 오래 기다려야 하는 현상



2) SJF(Shortest-Job-First)

- 다른 프로세스가 먼저 도착했더라도 CPU 버스트가 짧은 프로세스에게 CPU를 먼저 할당하는 방식이다.
- 선점, 비선점 모두 가능하다.

> 참고  
> <img src="https://user-images.githubusercontent.com/33534771/89703540-b7293e80-d986-11ea-9b11-0dabd8e5488f.png" width="300" height="300"/>
>
> ![img](https://user-images.githubusercontent.com/34755287/53879666-5d666b80-4052-11e9-93c2-86b725588403.png)
> 위의 간트 차트는 SJF를 사용했다. 평균 대기 시간은 아래와 같다.
> - Average Waiting Time(AWT) = 3 + 9 + 16 + 0 / 4 = 7msec
> 이번에는 위의 표를 FCSF를 사용해 간트 차트로 나타내고 평균 대기 시간을 구해보자.
> ![img](https://user-images.githubusercontent.com/34755287/53879667-5d666b80-4052-11e9-8cd4-066aefcf3047.png)
> - Average Waiting Time(AWT) = 0 + 6 + 14 + 21 / 4 = 10.25msec
> SJF가 평균 대기 시간이 더 짧다. 수학적으로 증명되었으며, 어떠한 예제를 보더라도 SJF의 AWT가 짧다는 것을 알 수 있을 것이다. 

- SJF가 가장 효율적인 CPU 스케줄링 방법 같지만, 매우 **비현실적**이다. 왜냐하면 컴퓨터 환경에서는 프로세스의 CPU 점유 시간(Burst time)을 알 수 없다. 한 프로세스가 실행 중에는 많은 변수가 존재하기 때문에 CPU 점유 시간을 알려면 실제로 수행하여 측정하는 수밖에 없다. 실제 측정한 시간으로 예측하여 SJF를 사용할 수도 있지만, 이는 오버헤드가 매우 큰 작업으로 잘 사용되지 않는다.

3) Priority

- 우선순위가 높은 프로세스가 먼저 선택되는 스케줄링 알고리즘이다.
- 우선순위는 정수값으로 나타내며, 작은 값이 우선순위가 높다.(Unix/Linux 기준)
- 우선순위가 낮은 프로세스가 무한정 기다리는 기아 상태가 발생할 수 있음 -> Aging 방법으로 해결필요
- 선점, 비선점 모두 가능하다.
    > Aging : ready queue에서 오래 기다릴수록 우선 순위를 높여주는 방법


### Reference

- [운영체제(OS) 6. CPU 스케줄링](https://velog.io/@codemcd/%EC%9A%B4%EC%98%81%EC%B2%B4%EC%A0%9COS-6.-CPU-%EC%8A%A4%EC%BC%80%EC%A4%84%EB%A7%81)
