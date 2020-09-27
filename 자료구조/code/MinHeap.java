package practice;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MinHeap {
	
	public static class minHeap {
		
		private ArrayList<Integer> heap;
		
		// �� ������
		public minHeap() {
			heap = new ArrayList<>();
			heap.add(0); // �ε��� 0 ä��� (1���� �����ϱ� ����)
		}
		
		// ����
		public void insert(int val) {
			heap.add(val);
			int p = heap.size() - 1;
			
			// �� ������ - 1�� 1���� �۾��� ������ ���� -> root�� �̵�
			while(p > 1 && heap.get(p / 2) > heap.get(p)) {
				System.out.println("swap");
				// �θ𺸴� �ڽ� ��尡 �� ������ �ٲ�� �� (�ּ���)
				int tmp = heap.get(p/2);
				heap.set(p/2, heap.get(p));
				heap.set(p, tmp);
				
				p = p / 2; // p�� �θ� ������ ���� (�θ� ��� �ε����� �̵�)
			}
		}
		
		// ����
		public int delete() {
			
			// �� ������ - 1�� 1���� ������ 0 ����
			if(heap.size()-1 < 1) {
				return 0;
			}
			
			// ������ ���� ��Ʈ �����
			int deleteItem = heap.get(1);
			
			// root�� ���� ������ �� �ְ� ������ �� ����
			heap.set(1, heap.get(heap.size() - 1));
			heap.remove(heap.size()-1);
			
			int pos = 1;
			while((pos * 2) < heap.size()) {
				
				int min = heap.get(pos * 2);
				int minPos = pos * 2;
				
				if (((pos*2 + 1) < heap.size()) && min > heap.get(pos*2 + 1)) {
					min = heap.get(pos*2 + 1);
					minPos = pos * 2 + 1;
				}
				
				if(heap.get(pos) < min)
					break;
				
				// �θ� �ڽ� ��� ��ȯ
				int tmp = heap.get(pos);
				heap.set(pos, heap.get(minPos));
				heap.set(minPos, tmp);
				pos = minPos;
			}
			
			return deleteItem;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		minHeap heap = new minHeap();
		
		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());
			
			if(val == 0) {
				System.out.println(heap.delete());
			} else {
				heap.insert(val);
			}
		}
		
	}

}
