## Tree

1. 트리의 개념.
2. 트리의 구성 요소.
3. 트리의 종류.



### 트리의 개념

트리라는 이름이 나온 이유는 실제 나무를 거꾸로 세워놓은 듯한 모양이라서 트리라고 부른다.

![img](https://k.kakaocdn.net/dn/bt7oXo/btqud7Jtl34/BZIJCBLvY19OsQPWTKMar0/img.png)

선형 자료구조에서 배열이나 리스트 등도 존재하지만, 트리가 나온 이유는 뭘까?

일반 배열에서 삽입이나 삭제를 하는데 O(N)의 시간이 걸린다. 배열의 첫번째 원소에 삽입하는 경우 나머지 모든 요소들을 한 칸씩 뒤로 미뤄야 하므로 최악의 시간 복잡도 O(N)이 나온다. 하지만, 트리는 편향 트리가 아닌 이상 일반적인 트리에서는 O(log N) 정도의 시간으로 줄여진다.



또한 트리는 계층 구조를 이루는 경우에 굉장히 좋다.

![img](https://k.kakaocdn.net/dn/bYGp1n/btqucn0M1cx/QO7cyWwxy9qJICKO1jmSf0/img.png)

회사의 조직도를 생각해보면, 맨 위에 회장님, 사장님이 있고, 부서별, 팀별로 각각 트리가 생길 것이다. 이런 경우, 원하는 부서를 타고 내려가기만 하면 되므로 다른 자료 구조보다 찾기가 훨씬 쉬울 것이다.



**특징**

- Tree는 Stack이나 Queue와 같이 선형 구조가 아닌 비선형 자료구조이다. 
- 계층적 관계를 표현한다.
- 루트 노드를 제외한 모든 노드는 단 하나의 부모 노드만을 갖는다.
- 방향성이 있는 비순환 그래프로 loop나 circuit이 없다.
- 루트에서 어떤 노드로 가는 경로는 유일하다.



### [트리의 구성 요소]

![img](https://k.kakaocdn.net/dn/cAInQg/btqudSFLXUP/ovj1R8NfO1cF85W1zbuAmk/img.png)

- Node : 트리를 구성하는 각각의 요소.
- Edge : 트리를 구성하기 위해 노드와 노드를 연결하는 선.
- 루트 노드-Root Node : 트리 구조에서 최상위에 있는 노드.
- 단말 노드-Terminal Node(= Leaf Node) : 하위에 다른 노드가 연결되어 있지 않은 노드.
- 내부 노드-Internal Node : 단말 노드를 제외한 모든 노드로 루트 노드를 포함한다. 



### [Binary Tree(이진 트리)]

![img](https://k.kakaocdn.net/dn/ZKPe7/btquds1DgyR/Q2T6uYRNDVEHSEqN7Ql5QK/img.png)

- 루트 노드를 중심으로 두 개의 서브 트리로 나뉘어 진다. (노드가 없을 수도 있다.) 나뉘어진 두 서브 트리도 모두 이진 트리어야 한다.
- 각 층별로 숫자를 매겨서 이를 트리의 레벨이라고 한다. 레벨은 1부터 시작하고 루트 노드의 레벨은 1이다. 트리의 최고 레벨을 가리켜 트리의 높이라고 한다.
- 종류
  - **Full Binary Tree(포화 이진 트리)** : 모든 레벨이 꽉 찬 이진 트리를 의미한다.
    - 레벨 별로 노드의 개수가 1,2,4,8,16 ... 으로 늘어난다. 따라서 일반적인 이진트리에서 각 레벨 별 최대 노드의 개수는 2^(k - 1)이 된다.
    - 레벨 별 노드는 공비가 2인 등비 수열이라고 볼 수 있으므로 등비수열의 합으로 생각하면 높이가 h인 이진트리가 가질 수 있는 최대 노드 수는 2^h - 1이라고 할 수 있다. 
  - **Complete Binary Tree(완전 이진 트리)** : 왼쪽에서 오른쪽으로 순서대로 차곡 차곡 채워진 이진 트리를 의미한다.
    - 노드를 삽입할 때 왼쪽부터 차례대로 삽입하는 트리이다. 왼쪽이 비어있고 오른쪽이 들어가있는 트리는 완전 이진 트리가 아니다.
  - **Skewed Binary Tree(편향 이진 트리)** : 모든 노드가 부모의 왼쪽 자식이기 때문에 왼쪽으로 편향되어 있거나 반대로 모든 노드가 부모의 오른쪽 자식이기 때문에 오른쪽으로 편향되어 있는 이진 트리를 말한다.
  - **Full Binary Tree(정 이진 트리)** : 단말 노드를 제외한 모든 노드가 자식노드를 2개 또는 0개 가지는 이진 트리

<br>

> ### 트리의 종류 - 설명은 별도 파일로 작성
> * **이진 트리**
>   * 부모 노드가 2개의 자식노드를 갖는 형태
>   * 이진 트리의 노드 상태에 따라 포화 이진트리, 완전 이진 트리, 정 이진 트리로 구별하기도 함   
>   * **Heap**  
>     * 완전 이진 트리의 일종으로 우선순위 큐에 활용됨 - 최대 힙, 최소 힙
>  * **이진 탐색 트리**
>    * 이진 트리 형태로 노드의 위치를 값의 비교로 정한 형태 - 숫자를 예로 부모의 노드는 왼쪽 자식 노드보다 크고 오른쪽 자식노드보다 작음
>    * 탐색에 효율적임
>    * 하지만 입출력되는 데이터에 따라 트리 구조가 편향되는 문제점 있음
>      * -> **균형 이진 탐색 트리**
>         * AVL, Red-Black Tree
>           * **AVL**
>             * 가장 초기의 균형 이진 탐색 트리
>             * 리프간 높이 차이가 커질 경우 회전(재구성)시키는 방식
>             * 트리 구조에 따라 회전 방식이 달라짐
>             * [추천 사이트](https://velog.io/@soonbee/AVL-Tree%EB%A5%BC-%EC%95%8C%EC%95%84%EB%B3%B4%EC%9E%90)
>           * **Red-Black Tree**
>             * [추천 사이트](https://nesoy.github.io/articles/2018-08/Algorithm-RedblackTree)
>             * [추천 사이트2](https://assortrock.com/87)
> * **B 트리**
>   * [추천 사이트](https://m.blog.naver.com/beaqon/221300200294)
>   * [추천 사이트2](https://hyungjoon6876.github.io/jlog/2018/07/20/btree.html)
>   * [추천 사이트3](https://gyoogle.dev/blog/computer-science/data-structure/B%20Tree%20&%20B+%20Tree.html)
> * **B+ 트리**
>   * [추천 사이트](https://ssoonidev.tistory.com/tag/B%2B%ED%8A%B8%EB%A6%AC)
>   * [추천 사이트2](https://gyoogle.dev/blog/computer-science/data-structure/B%20Tree%20&%20B+%20Tree.html)
> * **Trie 트라이**
>   * [추천 사이트](https://yabmoons.tistory.com/379)
>   * [추천 사이트2](https://brunch.co.kr/@springboot/75)
----




### 참고

- [[Java][자료구조] Tree (1) - 트리의 정의와 특성, 이진트리에 대하여](https://ju-nam2.tistory.com/25?category=868623)
