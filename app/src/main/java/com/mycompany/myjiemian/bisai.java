
   package com.mycompany.myjiemian;


        import android.os.Message;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.TextView;
        import java.io

        .IOException;
        import android.os.Handler;
        import org.jsoup.Jsoup;
        import org.jsoup.nodes.Document;
        import org.jsoup.select.Elements;


public class bisai extends AppCompatActivity {
    private static LinearLayout cx;
    private static int PageNumber = 0;
    private static String[][] linkTexts;
    private static String[][] linkAdds;
    private Button bt5;
    private static TextView tv;
    private static final int HASCRAWL=1;
    // private TextView tv=new TextView(this);


    private static Handler handler=new Handler(){

        @Override
        public void handleMessage(Message msg){
            if(msg.what==HASCRAWL){
                String temp=(String)msg.obj;
                tv.setText(temp);
            }
            super.handleMessage(msg);
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bisai);
        cx = (LinearLayout) findViewById(R.id.my_bisai);
        bt5 = (Button) findViewById(R.id.xinxi2);
        tv=(TextView)findViewById(R.id.tv);

        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(){
                    @Override
                    public void run(){
                        try{
                            crawInfo("赛");
                        }catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }
        });



    }

    private  static  void crawInfo(String keyWord) throws IOException{
        String url="http://jwc.scu.edu.cn/jwc/searchAll.action";
        int pageNow=1;

        Message msg=new Message();

        Document document=Jsoup.connect(url)
                .data("url",url,"keyWord",keyWord,"type","0","pager.pageNow",String.valueOf(pageNow))
                .post();

        String findToken1 = "页/共";
        String findToken2 = "页&nbsp";

			   /*
			    * 求页数
			    */
        PageNumber = Integer
                .parseInt(document.html().substring(document.html().indexOf(findToken1) + 3,
                        document.html().indexOf(findToken2)));

        linkTexts=new String[PageNumber+1][11];
        linkAdds=new String[PageNumber+1][11];



        for(int i=1;i<=PageNumber;i++) {
            Document doc=Jsoup.connect(url)
                    .data("url",url,"keyWord",keyWord,"type","0","pager.pageNow",String.valueOf(pageNow++))
                    .post();

            Elements element=doc.getElementsByClass("STYLE4");
            Elements allLinks=element.select("a[href]");
            for(int j=0;j<allLinks.size();j++) {
                linkTexts[i][j]=allLinks.get(j).text();
                linkAdds[i][j]="http://jwc.scu.edu.cn/jwc/" +allLinks.get(j).attr("href");
            }
        }
        String result="比赛信息:\n";
        for(int i=1;i<=PageNumber&&i<=10;i++)
            for(int j=1;j<=10;j++) {
                if(linkAdds[i][j]!=null)
                    result+=linkTexts[i][j]+"\n"+linkAdds[i][j]+"\n";
            }
        msg.what=HASCRAWL;
        msg.obj=result;
        handler.sendMessage(msg);
    }


}
