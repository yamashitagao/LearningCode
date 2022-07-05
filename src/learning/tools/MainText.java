package learning.tools;


import com.drew.lang.StringUtil;
import learning.myexception.BankFilesFormatException;

import java.io.*;
import java.math.BigDecimal;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @description
 * @author:Alexius
 * @time: 17:15
 * @date: 2021/5/29
 */


public class MainText {
    public static void main(String[] args) {

       String bankBill = "";
        try {
            FileReader fileReader = new FileReader("D:\\CPTCDZ_021009069_20220701.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String str = "";
            while((str = in.readLine()) != null){
                bankBill += str;
            }
//            System.out.println(bankBill);
        } catch (Exception e) {
            e.printStackTrace();
        }
        BankBean bankBean = dealBankBackFiles();
        List<BankBillList> bankBillLists = bankBean.getBankBillLists();
        FileReader fileReader = null;
        String[] id = new String[10];
        try {
            fileReader = new FileReader("D:\\111.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String str = "";//一行的内容
            String exceptionStr = "";
            int index = 0;  //行数
            List<String> s = new ArrayList<>();
            int i1 =0;
            while((str = in.readLine()) != null){
                s.add(str);
//                System.out.println(++i1);
            }

            List<String> d = new ArrayList<>();
            for (BankBillList bankBillList:
                    bankBillLists) {
                int i = 0; //2236
                d.add(bankBillList.getBarCode());
//                for (String d :
//                        s) {
//                    i++;
//                    if (d.equals(bankBillList.getBarCode())){
//                        break;
//                    }else{
//                        if (i>2233){
//                            System.out.println(bankBillList.getBarCode());
//                        }
//                    }
//                }
            }
            same(s);
            List<String> dif = new ArrayList<>();
            List<String> res = new ArrayList<>();
            dif.addAll(d);
            dif.retainAll(s);
            res.addAll(d);
            res.addAll(s);
            List<String> listWithoutDuplicates = res.stream().distinct().collect(Collectors.toList());
            listWithoutDuplicates.removeAll(dif);
            System.out.println(listWithoutDuplicates);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void same(List<String> list) {
        String [] indexArr ;
        Map<String, String> map = new HashMap<String, String>();
        for (int i = 0; i < list.size(); i++) {
            String key = list.get(i);
            String old = map.get(key);
            if (old != null) {
                map.put(key, old + "," + (i + 1));
            } else {
                map.put(key, "" + (i + 1));
            }
        }
        Iterator<String> it = map.keySet().iterator();
        int index = -1;
        while (it.hasNext()) {
            String key = it.next();
            String value = map.get(key);
            if (value.indexOf(",") != -1) {
                System.out.println(key + " 重复,行： " + value);
                indexArr = value.split(",");

                for (int i = 0; i < indexArr.length; i++) {
                    index = Integer.parseInt(indexArr[i])-1;
                    list.set(index, list.get(index)+(1+i));
                }
            }
        }

        for (String val : list) {
            System.out.println("val = "+val);
        }
        System.out.println("..................");

    }

    public static BankBean dealBankBackFiles() {
        BankBean bankBean  = new BankBean();

        List<BankBillList> bankBillLists = new ArrayList<>();
        String bankBill = "";
        try {
            FileReader fileReader = new FileReader("D:\\CPTCDZ_021009069_20220701.txt");
            BufferedReader in = new BufferedReader(fileReader);
            String str = "";//一行的内容
            String exceptionStr = "";
            int index = 0;  //行数
            while((str = in.readLine()) != null){

                BankBillList bankBillList = new BankBillList();
                if (index == 0){
                    String[] split = str.split("\\|");
                    if (split.length == 2){
                        bankBean.setCountList(Integer.valueOf(split[0]));
                        bankBean.setTotalMoney(new BigDecimal(split[1]));
                    }else{
                        exceptionStr +="\n 银行文件格式不匹配：第"+index+"行内容{"+str+"} ==> "+split.length + "个参数 ";

                    }
                }else{
                    String[] split = str.split("\\|");
                    if (split.length == 5){
                        bankBillList.setTradeTime(split[0]);
                        bankBillList.setBankCode(split[1]);
                        bankBillList.setUserCode(split[2]);
                        bankBillList.setBankMoney(new BigDecimal(split[3]));
                        bankBillList.setBarCode(split[4]);
                        bankBillLists.add(bankBillList);
                    }else{
                        exceptionStr +="\n 银行文件格式不匹配：第"+index+"行内容{"+str+"} ==> "+split.length + "个参数 ";
                    }
                }
                bankBill += str;
                index ++ ;
            }
            bankBean.setBankBillLists(bankBillLists);
            if(!"".equals(exceptionStr)){
                throw new BankFilesFormatException(exceptionStr);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BankFilesFormatException e) {
            e.printStackTrace();
        }
        return bankBean;
    }
}


class BankBean{
    private List<BankBillList> bankBillLists;
    private BigDecimal totalMoney;
    private Integer countList;

    public List<BankBillList> getBankBillLists() {
        return bankBillLists;
    }

    public void setBankBillLists(List<BankBillList> bankBillLists) {
        this.bankBillLists = bankBillLists;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getCountList() {
        return countList;
    }

    public void setCountList(Integer countList) {
        this.countList = countList;
    }
}
class BankBillList{
    private String tradeTime;
    private String bankCode;
    private String userCode;
    private BigDecimal bankMoney;
    private String barCode;

    public String getTradeTime() {
        return tradeTime;
    }

    public void setTradeTime(String tradeTime) {
        this.tradeTime = tradeTime;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public BigDecimal getBankMoney() {
        return bankMoney;
    }

    public void setBankMoney(BigDecimal bankMoney) {
        this.bankMoney = bankMoney;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }


}
