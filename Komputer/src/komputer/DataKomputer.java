package komputer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DataKomputer implements AppInterface {
    private final Komputer[] komputer;
    private DefaultTableModel tableModel;
    
    public DataKomputer(){
        komputer = new Komputer[1000];
        tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("Brand");
        tableModel.addColumn("Model");
        tableModel.addColumn("Disk Type");
        tableModel.addColumn("Disk Size");
        tableModel.addColumn("Ram Size");
    }

    @Override
    public int pilihanMenu() {
        String p =JOptionPane.showInputDialog(null, ""
                + "<html>"
                + "========Pilihan==================<br>"
                + "1 &rarr; Tambah Data Komputer<br>"
                + "2 &rarr; Cari Berdasarkan Brand Komputer<br>"
                + "3 &rarr; Cari Berdasarkan Model Komputer<br>"
                + "4 &rarr; Keluar Aplikasi<br>"
                + "===============================<br>"
                + "<b> Ketik Pilihan Anda:</b>"
                + "</html>",
                "Menu Pilihan",
                JOptionPane.QUESTION_MESSAGE);
        int pilihan = Integer.parseInt(p);
        return pilihan;
    }
    
    @Override
    public void viewTable(Komputer k){
         JTable table = new JTable(tableModel);
         JScrollPane scrollPane = new JScrollPane(table);
         JPanel panel = new JPanel();
         panel.add(scrollPane);
         
         JFrame frame = new JFrame("Data Komputer");
         frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
         frame.getContentPane().add(panel);
         frame.pack();
         frame.setVisible(true); 
    }

    @Override
    public void add() {
        Komputer kom = new Komputer ();
        String brand = JOptionPane.showInputDialog(null, "Ketik Brand:", ""
                + "Brand", JOptionPane.QUESTION_MESSAGE);
        kom.setBrand(brand);
        String model = JOptionPane.showInputDialog(null, "Ketik Model:", ""
                + "Model", JOptionPane.QUESTION_MESSAGE);
        kom.setModel(model);
        String disk = JOptionPane.showInputDialog(null, "Tipe Disk (SSD/hARDDISK):", ""
                + "Tipe Disk", JOptionPane.QUESTION_MESSAGE);
        kom.setDisk(disk);
        String size = JOptionPane.showInputDialog(null, "Kapasitas Disk (Angka):", ""
                + "Kapasitas Disk (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int diskSize = Integer.parseInt(size);
        kom.setDiskSize(diskSize);
        String ram = JOptionPane.showInputDialog(null, "Kapasitas RAM (Angka):", ""
                + "Ukuran RAM (dalam GB)", JOptionPane.QUESTION_MESSAGE);
        int ramSize = Integer.parseInt(ram);
        kom.setRam(ramSize);
        
        for (int i = 0; i < komputer.length; i++){
            if(komputer [i] == null){
                komputer[i] = kom;
                break;
            }
        }
        viewData(kom);
        Object[] rowData = {tableModel.getRowCount()+1, kom.getBrand(), kom.getModel(),kom.getDisk(), kom.getDiskSize(), kom.getRam()};
        tableModel.addRow(rowData);
        viewTable(kom);
    }

    @Override
    public String keyword(String type) {
        String key = JOptionPane.showInputDialog(null,
                "Ketik"+type+"komputer",
                type, JOptionPane.QUESTION_MESSAGE);
        return key;   
    }

    @Override
    public Komputer searchByBrand(String brand) {
        Komputer komp = null;
//        Mencari brand dengan hufuf kecil
        String lowerKeyword = brand.toLowerCase();
        
        for(Komputer k : komputer){
            if(k != null){
                String lowerBrand = k.getBrand().toLowerCase();
                if(lowerBrand.contains(lowerKeyword)){
                    komp = k;
                    break;
                }
            }
        }
        return komp;
    }
    
    @Override
    public Komputer searchByModel(String model) {
        Komputer komp = null;
        String lowerKeyword = model.toLowerCase();
        for(Komputer k : komputer){
            if(k != null){
                String lowerModel = k.getModel().toLowerCase();
                if(lowerModel.contains(lowerKeyword)){
                    komp = k;
                    break;
                }
                }
        }
          return komp;
    }

    @Override
    public void viewData(Komputer k) {
        if(k == null){
            JOptionPane.showMessageDialog(null, "Data tidak ditemukan");
        }else{
            JOptionPane.showMessageDialog(null,
                    "Brand\t\t: "+k.getBrand() +
                    "\nModel\t\t: "+k.getModel() +
                    "\nDisk Type\t: "+k.getDisk() +
                    "\nDisk Size\t: "+k.getDiskSize() +
                    "\nRAM Size\t: "+k.getRam(),
                    "Data Komputer",
                    JOptionPane.INFORMATION_MESSAGE);       
        }
    }

    @Override
    public void exit() {
       System.exit(0);
    }
    
}
