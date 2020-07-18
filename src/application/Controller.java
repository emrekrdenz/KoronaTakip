package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;

import com.sun.org.apache.xerces.internal.impl.dtd.models.CMNode;
import com.sun.xml.internal.ws.api.server.SDDocument;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class Controller implements Initializable{

	 public int istanbulHasta=0;
	    public int ankaraHasta=0;
	    public int hatayHasta=0;
	    public int izmirHasta=0;
	    public int  karsHasta=0;
	    											
	    public double istanbulS�cakl�k=0;
	    public double izmirS�cakl�k=0;
	    public double hatayS�cakl�k=0;
	    public double karsS�cakl�k=0;
	    public double ankaraS�cakl�k=0;
	    
	    @FXML
	    private Button sorgula;
	    String semt;
	    String muhtarmail;
	 Double derece_kac;
	 String sehir;
	 LocalDate tarihh;
	 int sayac=0;
	 
    @FXML
    private TableView<hastalar> hastatablosu;

    @FXML
    private TableColumn<hastalar,String> chastaAdi;

    @FXML
    private TableColumn<hastalar,String> chastaMemleket;

    @FXML
    private TableColumn<hastalar,String> chastaMeslek;

    @FXML
    private TableColumn<hastalar,String> chastaCinsiyet;

    @FXML
    private TableColumn<hastalar,String> chastaTeshis;

    @FXML
    private TableColumn<hastalar, String> chastaAtes;
    
    @FXML
    private TableColumn<hastalar, LocalDate> tbl_tarih;

    @FXML
    private TableColumn<hastalar, String> tbl_muhtarlik;

    @FXML
    private TableColumn<hastalar, String> tbl_mail;
    
    @FXML
    private PieChart grafik2;

    @FXML
    private BarChart<String, Integer> grafik;

    @FXML
    private CategoryAxis grafik_sehir;


    @FXML
    private CheckBox check_teshis;
    
    
    @FXML
    private DatePicker dateGirisTarihi;

    @FXML
    private Slider slider1;

    @FXML
    private TextField muhtar;

    @FXML
    private TextField mahalle;
    
    @FXML
    private ComboBox<String> cmbMemleket;

    @FXML
    private TextField txtAd;

    @FXML
    private ToggleGroup cinsiyet;

   
    @FXML
    private ToggleGroup meslek;

    @FXML
    private Label sliderLabel;
    
    @FXML
    void cmbMemleket_Ekle(ActionEvent event) {
    	sehir=cmbMemleket.getValue();
    }
    
     
    ObservableList<hastalar>veriler;  //kay�tlar class�ndan gelecek
    
    @FXML
    void check_teshis_click(ActionEvent event) {
    	sayac++;
    	if(sayac%2==1) {
    		check_teshis.setText("Pozitif");
    	}
    	if(sayac%2==0) {
    		check_teshis.setText("Negatif");
    	}
    }
	  
    @FXML
 	    void dateGirisGoster(ActionEvent event) {
    	LocalDate Tarih= dateGirisTarihi.getValue();
 		tarihh=Tarih;
 		
 	  }
    @FXML
    void grafik2_cliked(MouseEvent event) {

    	int istanbulindex=0;
    	int ankaraindex=0;
    	int hatayindex=0;
    	int izmirindex=0;
     	int karsindex=0;
     	
         for(hastalar grafikHasta : hastatablosu.getItems())
         {
        	 if(grafikHasta.getMemleket().equalsIgnoreCase("�stanbul")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        	 	{
        		 istanbulindex++;
    		
    		 	}
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("Ankara")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			ankaraindex++;
        		 }
        		 
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("Hatay")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			hatayindex++;
        		
        		 }
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("�zmir")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			izmirindex++;
        		 }
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("Kars")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			karsindex++;
        			
        		 }
         }

        		 ObservableList<PieChart.Data> pieChartData =
             			FXCollections.observableArrayList( new PieChart.Data("�stanbul", (istanbulindex*100)/5),
             					new PieChart.Data("Ankara", (ankaraindex*100)/5),
             					new PieChart.Data("Hatay", (hatayindex*100)/5),
             					new PieChart.Data("�zmir", (izmirindex*100)/5),
             					new PieChart.Data("Kars", (karsindex*100)/5));
             	final PieChart chart = new PieChart(pieChartData);
             	grafik2.setTitle("Hastal�k Y�zdeleri"); 
             	grafik2.setData(pieChartData);
         
     
    }
   
     @FXML
     void initialize() {
    	  			
    	
    	 
    		
     	//TableViewe Kayit Girme
     	veriler=FXCollections.observableArrayList();
     	//veriler.add(new hastalar("EMRE KARADEN�Z","Kars","��renci","Erkek","36.00","Pozitif","11.12,2012"));
     	
     	//ilk id Tableview(sutun isimleri) i�erisindeki sutun adi,ikinci id kayitlar classindan gelen id
     	
     	chastaAdi.setCellValueFactory(new PropertyValueFactory<>("chastaAdi"));
     	chastaAtes.setCellValueFactory(new PropertyValueFactory<>("chastaAtes"));
     	chastaCinsiyet.setCellValueFactory(new PropertyValueFactory<>("chastaCinsiyet"));
     	chastaMemleket.setCellValueFactory(new PropertyValueFactory<>("memleket"));
     	chastaMeslek.setCellValueFactory(new PropertyValueFactory<>("chastaMeslek"));
     	chastaTeshis.setCellValueFactory(new PropertyValueFactory<>("chastaTeshis"));
     	tbl_tarih.setCellValueFactory(new PropertyValueFactory<>("Tarih"));
     	tbl_muhtarlik.setCellValueFactory(new PropertyValueFactory<>("muhtarlik"));
     	tbl_mail.setCellValueFactory(new PropertyValueFactory<>("mail"));
     	
     	hastatablosu.setItems(veriler);
     	
     	//tableView sutunun gorunmez  yapma=kul_adi.setVisible(false);sifre.setVisible(false);
     	
    ////MEMLEKET COMBOBOXSINA ELEMAN EKLEME 	
		
		ObservableList<String>sehirler=FXCollections.observableArrayList("�stanbul","Ankara","Hatay","�zmir","Kars");
		cmbMemleket.setItems(sehirler);
		//Grafikte x de�erleri
		grafik_sehir.setCategories(sehirler);
	
	 ////////////******************
		
		///////////SL�DER KISMI		
   	 slider1.setMax(43.7);
   	 slider1.setMin(21.0);
   	 slider1.setValue(40);
   	 slider1.setShowTickLabels(true);
   	 slider1.setShowTickMarks(true);
   	 slider1.setMajorTickUnit(5);
   	 slider1.setMinorTickCount(10);
   	 slider1.setBlockIncrement(3);
   	 slider1.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observed, Number oldValue, Number newValue) {

          	  sliderLabel.setText(newValue+"");
          	 
            }
        });

		
     }
  
    @FXML
    void hastaEkle(ActionEvent event) {
    	try {
    	RadioButton cins=(RadioButton) cinsiyet.getSelectedToggle();  //hasta cinsiyeti burada toggledan d�n���m
        RadioButton mesle1=(RadioButton)meslek.getSelectedToggle();   //hasta meslek burada 
        String ates=sliderLabel.getText();
        semt=muhtar.getText();
        muhtarmail=mahalle.getText(); 
       
    	veriler=FXCollections.observableArrayList();
    	veriler.add(new hastalar(txtAd.getText(),sehir,mesle1.getText(),cins.getText(),ates,check_teshis.getText(),tarihh,semt,muhtarmail));
    	hastatablosu.getItems().addAll(veriler); 
    	
    	
       	//ad_soyad.setVisible(false);
    			Alert alert = new Alert(AlertType.INFORMATION);
                 	alert.setTitle("EKLEME OLANI");
                 	alert.setHeaderText(null);
                 	alert.setContentText("EKLEME BA�ARILI");
                 	alert.showAndWait();
                    
                	if(cmbMemleket.getSelectionModel().getSelectedIndex()==0)
                	{
                		istanbulHasta++;
                		istanbulS�cakl�k+=Double.parseDouble(ates);
                	}
                	
                	
                	if(cmbMemleket.getSelectionModel().getSelectedIndex()==1)
                	{
                		ankaraHasta++;
                		ankaraS�cakl�k+=Double.parseDouble(ates);
                	}
               	 
                	if(cmbMemleket.getSelectionModel().getSelectedIndex()==2)
                	{
                		hatayHasta++;
                		hatayS�cakl�k+=Double.parseDouble(ates);
                	}
                	
                    
                	if(cmbMemleket.getSelectionModel().getSelectedIndex()==3)
                	{
                		izmirHasta++;
                		izmirS�cakl�k+=Double.parseDouble(ates);
                	}
                	
                    if(cmbMemleket.getSelectionModel().getSelectedIndex()==4) {
                    	karsHasta++;
                    	karsS�cakl�k+=Double.parseDouble(ates);
                    }
    		} catch (Exception e) {
    			e.printStackTrace();
    		}
 
       }

    @FXML
    void hastaGuncelle(ActionEvent event) {
    
    	hastalar veriler=hastatablosu.getSelectionModel().getSelectedItem();

    	Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("G�ncelleme Onay�");
    	alert.setHeaderText("G�ncelleme onay� bekleyiniz.");
    	alert.setContentText("G�ncellemek istiyor musunuz?");
    	Optional<ButtonType> result = alert.showAndWait();
    	if (result.get()==ButtonType.OK) {
    	
    		String AdSoyad=txtAd.getText();
    		RadioButton mesle1=(RadioButton)meslek.getSelectedToggle();
    		String meslek=mesle1.getText();
    		String sehir=cmbMemleket.getSelectionModel().getSelectedItem().toString();
    		RadioButton cins=(RadioButton)cinsiyet.getSelectedToggle();
    		String cinsiyet=cins.getText();
    	
    	veriler.setChastaAdi(AdSoyad);
    	veriler.setChastaMeslek(meslek);
    	veriler.setMemleket(sehir);
    	veriler.setChastaCinsiyet(cinsiyet);
    	veriler.setChastaAtes(sliderLabel.getText());
    	hastatablosu.refresh();
    	
    	
    	}
    }
    
   

    private RadioButton getSelectedToggle() {
		// TODO Auto-generated method stub
		return null;
	}

	@FXML
    void hastaSil(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
    	alert.setTitle("Silme i�in onay");
    	alert.setHeaderText("Silmek i�in onay bekleyiniz. ");
    	alert.setContentText("Silmek istiyor musunuz?");
    	Optional<ButtonType> result = alert.showAndWait();

    	ObservableList<hastalar>secilenKayit,tumKayitlar;
    	tumKayitlar=hastatablosu.getItems();
    	secilenKayit=hastatablosu.getSelectionModel().getSelectedItems();
    	secilenKayit.forEach(tumKayitlar::remove);
    	
    	
    }
	 @FXML
	    void hastaSorgula(ActionEvent event) {
	    	
	    	
	    
	    
	    	Alert alarm = new Alert(AlertType.CONFIRMATION);
	     	alarm.setTitle("SORGULAMA ��LEM�");
	     	alarm.setHeaderText(null);
	     	alarm.setContentText("SORGULAMAK �STED���N�ZDEN EM�N M�S�N�Z?");

	     	Optional<ButtonType> result = alarm.showAndWait();
	    	if(cmbMemleket.getSelectionModel().getSelectedIndex()==0)
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
	        	alert.setTitle("�STANBUL GENEL� COV�D19 B�LG�S�:");
	        	alert.setHeaderText("�stanbuldaki Hasta Say�s�: "+istanbulHasta+"\n �stanbuldaki Hastalar�n Ortalama Ate�i: "+ (double)istanbulS�cakl�k/istanbulHasta);
	        	alert.showAndWait();	
	    		
	    	}
	  	
	    	if(cmbMemleket.getSelectionModel().getSelectedIndex()==1)
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
	        	alert.setTitle("ANKARA GENEL� COV�D19 B�LG�S�:");
	        	alert.setHeaderText("Ankaradaki Hasta Say�s�: "+ankaraHasta+"\n Ankaradaki Hastalar�n Ortalama Ate�i: "+ ankaraS�cakl�k/ankaraHasta);
	        	alert.showAndWait();
	    		
	    	}
	    	if(cmbMemleket.getSelectionModel().getSelectedIndex()==3)
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
	        	alert.setTitle("�ZM�R GENEL� COV�D19 B�LG�S�:");
	        	alert.setHeaderText("�zmirdeki Hasta Say�s�: "+izmirHasta+"\n �zmirdeki Hastalar�n Ortalama Ate�i: "+ izmirS�cakl�k/izmirHasta);
	        	alert.showAndWait();
	    		
	    	}
	    	
	    	if(cmbMemleket.getSelectionModel().getSelectedIndex()==2)
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
	        	alert.setTitle("HATAY GENEL� COV�D19 B�LG�S�:");
	        	alert.setHeaderText("Hataydaki Hasta Say�s�: "+hatayHasta+"\n Hataydaki Hastalar�n Ortalama Ate�i: "+ hatayS�cakl�k/hatayHasta);
	        	alert.showAndWait();
	    		
	    	}
	   	
	    	if(cmbMemleket.getSelectionModel().getSelectedIndex()==4)
	    	{
	    		Alert alert = new Alert(AlertType.INFORMATION);
	        	alert.setTitle("KARS GENEL� COV�D19 B�LG�S�:");
	        	alert.setHeaderText("Karstaki Hasta Say�s�: "+karsHasta+"\n Karstaki Hastalar�n Ortalama Ate�i: "+ (double) karsS�cakl�k/karsHasta);
	        	alert.showAndWait();
	    	}
	    	else {
	    		alarm.close();
	    	}
	    
	    	
	    }

	ObservableList<hastalar>hasta=FXCollections.observableArrayList();
	

    @FXML
    void grafik_cliked(MouseEvent event) {
     	

    	int istanbulindex=0;
    	int ankaraindex=0;
    	int hatayindex=0;
    	int izmirindex=0;
     	int karsindex=0;
     	
         for(hastalar grafikHasta : hastatablosu.getItems())
         {
        	 if(grafikHasta.getMemleket().equalsIgnoreCase("�stanbul")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        	 	{
        		 istanbulindex++;
    		
    		 	}
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("Ankara")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			ankaraindex++;
        		 }
        		 
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("Hatay")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			hatayindex++;
        		
        		 }
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("�zmir")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			izmirindex++;
        		 }
        		 if(grafikHasta.getMemleket().equalsIgnoreCase("Kars")&&grafikHasta.getChastaTeshis().equalsIgnoreCase("Pozitif"))
        		 {
        			karsindex++;
        			
        		 }
        			XYChart.Series<String, Integer> series = new XYChart.Series<>();                
             		for (int i = 0; i < 5 ; i++) {          
             			
             			series.getData().add(new Data<String, Integer>("�stanbul",istanbulindex));
             			series.getData().add(new Data<String, Integer>("Ankara",ankaraindex));
             			series.getData().add(new Data<String, Integer>("Hatay",hatayindex));
             			series.getData().add(new Data<String, Integer>("�zmir",izmirindex));
             			series.getData().add(new Data<String, Integer>("Kars",karsindex));
             		
             			}     
             		grafik.getData().clear();
             		grafik.getData().add(series);
         }
    	
    }
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
	initialize();

	
	}
}
