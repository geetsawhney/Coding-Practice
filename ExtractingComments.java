

import java.io.*;
import java.util.List;
import java.util.ArrayList;

public class ExtractingComments {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        
        List<String> pr=new ArrayList<>();
        String line=br.readLine();
        while(line!=null){
            pr.add(line);
            line=br.readLine();
        }
       
        List<String> comment=new ArrayList<>();
        
        for(int i=0;i<pr.size();i++){
            if(pr.get(i).indexOf("/*")!=-1){
                if(pr.get(i).indexOf("*/")!=-1){
                    comment.add(pr.get(i).substring(pr.get(i).indexOf("/*"),pr.get(i).indexOf("*/"+2)));
                    if(pr.get(i).indexOf("//")!=-1)
                        comment.add(pr.get(i).substring(pr.get(i).indexOf("//")));
                } else{
                    while(pr.get(i).indexOf("*/")==-1){
                        comment.add(pr.get(i));
                        i++;
                        if(i>=pr.size())
                            break;
                    }
                    comment.add(pr.get(i).substring(0,pr.get(i).indexOf("*/")+2));
                    if(pr.get(i).indexOf("//")!=-1)
                        comment.add(pr.get(i).substring(pr.get(i).indexOf("//")));
                }
            }else if(pr.get(i).indexOf("//")!=-1)
                comment.add(pr.get(i).substring(pr.get(i).indexOf("//")));
        }
        
        for(String p:comment){
            System.out.println(p.trim());
        }
    }
}