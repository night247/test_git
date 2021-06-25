package GameofLife;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Game_GUI extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game_GUI frame = new Game_GUI(2,2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Game_GUI(int l,int w) {
		setTitle("\u751F\u547D\u6E38\u620F");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 10*l, 10*w+20);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(l,w));
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		Chessboard_GUI test=new Chessboard_GUI(l,w);//���ݳ���������
		test.Init();
		
		int Cell[][]=test.getCell();//ȡ�ó�ʼ���������
		JButton[][] buttonArr=new JButton[l][w];//�����������ý���
		for(int i=0;i<l;i++) {
			for(int j=0;j<w;j++) {
				buttonArr[i][j]=new JButton();
				panel.add(buttonArr[i][j]);
				if(Cell[i][j]==1) {
					buttonArr[i][j].setBackground(Color.BLACK);//��ϸ�����ú�ɫ
					buttonArr[i][j].setOpaque(true); //foreground����͸��
				}else {
					buttonArr[i][j].setBackground(Color.WHITE);//��ϸ�����ð�ɫ
					buttonArr[i][j].setOpaque(false); //foreground����͸��
				}
			}
		}
		
		JButton nextButton=new JButton("��һ��");//��һ����ť
		panel_1.add(nextButton, BorderLayout.CENTER);
		nextButton.addActionListener(new ActionListener() {
			public  void actionPerformed(ActionEvent e) {
				//new Thread() {
				// TODO �Զ����ɵķ������
				
				test.getNext();//������һ��������
				int Cell[][]=test.getCell();//ȡ����һ��������
				for(int i=0;i<l;i++) {
					for(int j=0;j<w;j++) {
						if(Cell[i][j]==1) {
							buttonArr[i][j].setBackground(Color.BLACK);//��ϸ�����ú�ɫ
							buttonArr[i][j].setOpaque(true); //foreground����͸��
						}else {
							buttonArr[i][j].setBackground(Color.WHITE);//��ϸ�����ð�ɫ
							buttonArr[i][j].setOpaque(false); //foreground����͸��
						}
					}
				}
				
		//	}.start();
		}
		});
	}
}
