package GameofLife;

import java.util.Scanner;

public class Chessboard_GUI {
	public int l,w;
	public int Cell[][];
	public Chessboard_GUI(int l,int w) {
		this.l=l;
		this.w=w;
	}
	public void Init() {//��ʼ������
//		System.out.println("��������ӵĳ���");
//		Scanner scan = new Scanner(System.in);
//		l=scan.nextInt();
//		w=scan.nextInt();
		Cell=new int[l][w];
	//�������������ϸ����״̬��1��������0������
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				if (Math.random()>0.5)    //�������������ʼ��ϸ��������״̬
					Cell[i][j]=1;
				else
					Cell[i][j]=0;
			}
		}
//		PrintOut();
	}
	public void getNext() {//��ȡ��һʱ�̵�״̬
		int Cell1[][]=new int[l][w];//����Cell�ĸ���
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				if(Cell[i][j]==1) {
					if(getNeighbors(i,j)==2||getNeighbors(i,j)==3) Cell1[i][j]=1;
					else Cell1[i][j]=0;
				}else {
					if(getNeighbors(i,j)==3) Cell1[i][j]=1;
					else Cell1[i][j]=0;
				}
			}
		}
		Cell=Cell1;
//		PrintOut();
	}
	public int getNeighbors(int i,int j) {//���Cell[i][j]��Χ���ϸ������
        int n=0;
        n+=cellState(i-1,j-1);    //�Ź����ж�
        n+=cellState(i-1,j);
        n+=cellState(i-1,j+1);
        n+=cellState(i,j-1);
        n+=cellState(i,j+1);
        n+=cellState(i+1,j-1);
        n+=cellState(i+1,j);
        n+=cellState(i+1,j+1);
        return n;
	}
	public int cellState(int i,int j) {//��ȡCell[i][j]ϸ��״̬
        boolean State=!(i<0||i>=l||j<0||j>=w||Cell[i][j]==0);
        return State?1:0;
    }

	public int[][] getCell() {
		return Cell;
	}
	public void setCell(int[][] cell) {
		Cell = cell;
	}
}
