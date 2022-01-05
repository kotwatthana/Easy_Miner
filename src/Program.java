import javax.swing.*;
import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Program extends JFrame implements ActionListener {
    JPanel Panel_black = new JPanel();
    JLabel pro = new JLabel("Program");
    JLabel coin = new JLabel("Coin");

    String[] miner = {"","NBMiner","T-rex","GMiner","lolminer"};
    String[] nbcoin = {"ETC","ETH","AE","RVN","BEAM","CFX","ERGO"};
    String[] trex = {"autolykos2","etchash","ethash","firopow","kawpow","mtp","mtp-tcr","multi","octopus","progpow","progpow-veil","progpow-veriblock","progpowz"};
    String[] gminer = {"ETC","ETH","AE","RVN","BEAM","Cortex","Equihash144_5","Equihash125_4","Equihash192_7","Equihash210_9"};
    String[] lolminer = {"TON","Autolykos V2" , "BeamHash III" , "Cuckoo 29" , "CuckarooD 29" , "CuckarooM 29" , "Cuckaroo 30 CTXC" , "Cuckatoo 31" , "Cuckatoo 32" , "Cuckaroo 29-32" , "Cuckaroo 29-40" , "Equihash 144/5" , "Equihash 192/7" , "Equihash 210/9" , "Etchash" , "Ethash" , "ZelHash"};

    JLabel pool = new JLabel("Pool");
    JTextField tpool = new JTextField();

    JLabel port = new JLabel("Port");
    JTextField tport = new JTextField();

    JLabel wallet = new JLabel("Wallet");
    JTextField twallet = new JTextField();

    JLabel worker = new JLabel("Worker");
    JTextField tworker = new JTextField();

    JLabel pass = new JLabel("Password");
    JTextField tpass = new JTextField("x");

    JComboBox program = new JComboBox(miner);
    JComboBox coin_support = new JComboBox();

    Font font = new Font("Fira code",Font.BOLD,10);

    AbstractBorder brdr = new TextBubbleBorder(null,2,16,0);

    JButton create = new JButton("Create");
    JButton start_stop = new JButton("Start");



    public Program(){
        this.setSize(1000,600);
        this.setTitle("Easy Miner");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);

        add(Panel_black);
        Panel_black.setBounds(0,0,1000,600);
        Panel_black.setLayout(null);

        Panel_black.add(pro);
        pro.setBounds(50,20,100,50);
        Panel_black.add(program);
        program.setBounds(105,20,150,50);
        program.addActionListener(this);

        Panel_black.add(coin);
        coin.setBounds(275,20,35,50);
        Panel_black.add(coin_support);
        coin_support.setBounds(315,20,150,50);
        coin_support.addActionListener(this);

        Panel_black.add(pool);
        pool.setBounds(485,20,35,50);
        Panel_black.add(tpool);
        tpool.setBounds(525,30,170,30);

        Panel_black.add(port);
        port.setBounds(715,20,35,50);
        Panel_black.add(tport);
        tport.setBounds(785,30,100,30);

        Panel_black.add(wallet);
        wallet.setBounds(50,60,100,30);
        Panel_black.add(twallet);
        twallet.setBounds(105,60,355,30);

        Panel_black.add(worker);
        worker.setBounds(475,60,50,30);
        Panel_black.add(tworker);
        tworker.setBounds(525,60,170,30);

        Panel_black.add(pass);
        pass.setBounds(715,60,60,30);
        Panel_black.add(tpass);
        tpass.setBounds(785,60,100,30);

        Panel_black.add(create);
        create.setBounds(180,100,300,50);
        create.addActionListener(this);

        Panel_black.add(start_stop);
        start_stop.setBounds(520,100,300,50);
        start_stop.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String set_file = "";
        if (e.getSource() == program){
            if (program.getSelectedItem() == ""){
                coin_support.removeAllItems();
            }
            if (program.getSelectedItem() == "NBMiner"){
                coin_support.removeAllItems();
                for (int i = 0;i<nbcoin.length;i++){
                    coin_support.addItem(nbcoin[i]);
                }
            }
            if (program.getSelectedItem() == "T-rex"){
                coin_support.removeAllItems();
                for (int i = 0;i<trex.length;i++){
                    coin_support.addItem(trex[i]);
                }
            }
            if (program.getSelectedItem() == "GMiner") {
                coin_support.removeAllItems();
                for (int i = 0; i < gminer.length; i++) {
                    coin_support.addItem(gminer[i]);
                }
            }
            if (program.getSelectedItem() == "lolminer") {
                coin_support.removeAllItems();
                for (int i = 0; i < lolminer.length; i++) {
                    coin_support.addItem(lolminer[i]);
                }
            }
        }
        if (e.getSource() == create){
            try{
                if (program.getSelectedItem() == "NBminer") {
                    set_file = String.valueOf("nbminer" + " -a " + coin_support.getSelectedItem() + " -o  " + tpool.getText() + ":" + tport.getText() + " -u " + twallet.getText() + "." + tworker.getText() + " -log"
                            + "\npause");
                }
                if (program.getSelectedItem() == "T-rex"){
                    set_file = String.valueOf("t-rex" + " -a " + coin_support.getSelectedItem() + " -o  " + tpool.getText() + ":" + tport.getText() + " -u " + twallet.getText() + "." + tworker.getText()
                            + "\npause");
                }
                if (program.getSelectedItem() == "GMiner") {
                    set_file = String.valueOf("miner" + " --algo " + coin_support.getSelectedItem() + " --server  " + tpool.getText() + ":" + tport.getText() + " --user " + twallet.getText() + "." + tworker.getText()
                            + "\npause");
                }
                if (program.getSelectedItem() == "lolminer") {
                    set_file = String.valueOf("lolMiner" + " --algo " + coin_support.getSelectedItem() + " --pool  " + tpool.getText() + ":" + tport.getText() + " --user " + twallet.getText() + "." + tworker.getText()
                            + "\npause");
                }
                System.out.println(set_file);
                FileWriter writer=new FileWriter("configmine.bat");
                writer.write(set_file);
                writer.close();
            }
            catch (FileNotFoundException x){}
            catch (IOException xx){}

        }
        if (e.getSource() == start_stop){

        }

    }
}