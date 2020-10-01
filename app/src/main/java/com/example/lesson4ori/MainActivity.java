package com.example.lesson4ori;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener {
    ListView ls;
    Spinner snCo;
    Spinner snCou;
    TextView population;
    TextView square;
    String[] lands;
    int row;
    ArrayAdapter<String> adp;
    String[][] countries;
    String[][][][] info;
    String[][][] city;
    int country;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        row = 0;

        snCo = (Spinner)findViewById(R.id.contimentSp);
        snCou = (Spinner)findViewById(R.id.countriesSp);

        ls = (ListView) findViewById(R.id.ls);
        population = (TextView) findViewById(R.id.pop);
        square = (TextView) findViewById(R.id.squre);
        lands = new String[]{"continent","Africa","Europe","Asia","America"};
        countries = new String[][]{{"country","Nigeria","Ethiopia","Egypt","South Africa","Kenya","Uganda","Algeria"},
                {"country","Russia","Germany","United Kingdom","France","Italy","Spain","Ukraine"},
                {"country","China","India","Indonesia","Pakistan","Bangladesh","Japan","Philippines"}
                ,{"country","United States","Brazil","Mexico","Colombia","Argentina","Canada","Peru"}};
        info = new String[][][][] { {    { {"999.6 km2","23,437,435"}, //Niferia
                {"Amharic","109.2M","Ethiopia, Be happy","Addis Ababa" },//Ethiopia
                {"Masri","98.42M","Bilady, Bilady, Bilady","Cairo" },
                {"Afrikaans","57.78M","National anthem of South Africa","Pretoria" },
                {"Swahili","47.564M","Ee Mungu Nguvu Yetu","Nairobi" },
                {"English and Swahili","42.729M","Oh Uganda, Land of Beauty","Kampala" },
                {"Arabic and Berber","43.6M","Kassaman","Algiers" }},
                { {"Russian","146.748M","Государственный гимн Российской Федерации","Moscow"},
                        {"German","83.166M","Deutschlandlied","Berlin" },
                        {"English","67.886M","God Save the Queen","London" },
                        {"French","67.081M","La Marseillaise","Paris" },
                        {"Italian","60.3174M","The Song of the Italians","Rome" },
                        {"Spanish","47.431M","Marcha Real","Madrid" },
                        {"Ukrainian","41.660M","Derzhavnyi Himn Ukrayiny","Kyiv" }} ,
                { {"Standard Chinese","1,400,050,000","义勇军进行曲","Beijing"},
                        {"Hindi and English","1,352,642,280","Jana Gana Mana","New Delhi" },
                        {"Indonesian","267.670M","Indonesia Raya","Jakarta" },
                        {"English and Urdu","212,228M","Qaumī Tarānah","Islamabad" },
                        {"Bengali","161.376M","Amar Sonar Bangla","Dhaka" },
                        {"Japanese","125.960M","Kimigayo","Tokyo" },
                        {"Filipino and English","109.048M","Lupang Hinirang","Manila" }},
                { {"English","328.239M","The Star-Spangled Banner","Washington, D.C."},
                        {"Portuguese","210.147M","Hino Nacional Brasileiro","Brasília" },
                        {"Spanish","128.649M","Himno Nacional Mexicano","Mexico City" },
                        {"English and Spanish","50.372M","Himno Nacional de la República de Colombia","Bogotá" },
                        {"None(there are many languages)","44.938M","Himno Nacional Argentino","Buenos Aires" },
                        {"English and French","37.971M","O Canada","Ottawa" },
                        {"Spanish","32.824M","Himno Nacional del Perú","Lima" }}}};

        //world { continent{   { country1{city{popalation,squre}} }

        city = new String[][][] {{ {"Lagos","Kano","Ibadan","Benin City","Port Harcourt"}, //Niferia
                {"Addis Ababa","Mekelle","Gondar", "Adama","Hawassa" },//Ethiopia
                {"Abu El Matamir","Abu Hummus","Baltim","Cairo","Bilbeis"},
                {"Aberdeen","Aberfeldy","Albertinia","Balmoral","Aurora" },
                {"Nakuru","Ruiru","Eldoret","Nairobi","Naivasha"},
                {"Kampala","Nansana","Kira","Ssabagabo","Mbarara"},
                {"Oran","Constantine","Batna","Algiers","Djelfa" }},
                { {"Abakan","Abdulino","Belinsky","Moscow","Beslan"},
                        {"Haan","Kaarst","Kaltenkirchen","Berlin","Kenzingen" },
                        {"Bristol","Ely","Hereford","London","Leicester" },
                        {"French","67.081M","La Marseillaise","Paris" ,""},
                        {"Italian","60.3174M","The Song of the Italians","Rome" },
                        {"Spanish","47.431M","Marcha Real","Madrid" },
                        {"Ukrainian","41.660M","Derzhavnyi Himn Ukrayiny","Kyiv" }} ,
                { {"Standard Chinese","1,400,050,000","义勇军进行曲","Beijing"},
                        {"Hindi and English","1,352,642,280","Jana Gana Mana","New Delhi" },
                        {"Indonesian","267.670M","Indonesia Raya","Jakarta" },
                        {"English and Urdu","212,228M","Qaumī Tarānah","Islamabad" },
                        {"Bengali","161.376M","Amar Sonar Bangla","Dhaka" },
                        {"Japanese","125.960M","Kimigayo","Tokyo" },
                        {"Filipino and English","109.048M","Lupang Hinirang","Manila" }},
                { {"English","328.239M","The Star-Spangled Banner","Washington, D.C."},
                        {"Portuguese","210.147M","Hino Nacional Brasileiro","Brasília" },
                        {"Spanish","128.649M","Himno Nacional Mexicano","Mexico City" },
                        {"English and Spanish","50.372M","Himno Nacional de la República de Colombia","Bogotá" },
                        {"None(there are many languages)","44.938M","Himno Nacional Argentino","Buenos Aires" },
                        {"English and French","37.971M","O Canada","Ottawa" },
                        {"Spanish","32.824M","Himno Nacional del Perú","Lima" }}};
        adp = new ArrayAdapter<String>(this
                ,R.layout.support_simple_spinner_dropdown_item,lands);
        snCo.setAdapter(adp);
        snCo.setOnItemSelectedListener(this);
        snCou.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        population.setText(info[row][country][i][1]);
        square.setText(info[row][country][i][0]);
    }

    @Override
    public void onItemSelected(AdapterView<?> AdapterView, View view, int i, long l) {
        if(AdapterView.getId() == (R.id.countriesSp))
        {
            if (i != 0) {
                country = i-1;
                ls.setVisibility(View.VISIBLE);

                adp = new ArrayAdapter<String>(this
                        , R.layout.support_simple_spinner_dropdown_item, city[row][i - 1]);
                ls.setAdapter(adp);
                ls.setOnItemClickListener(this);
            }
            else
            {
                ls.setVisibility(View.INVISIBLE);
            }

        }
        else if (AdapterView.getId() == (R.id.contimentSp))
        {
            if (i != 0)
            {
                adp = new ArrayAdapter<String>(this
                        ,R.layout.support_simple_spinner_dropdown_item,countries[i-1]);
                snCou.setAdapter(adp);
                row = i-1;
            }
            else
            {
                snCou.setAdapter(null);
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}