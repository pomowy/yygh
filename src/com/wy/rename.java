package com.wy;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;
import org.junit.Test;

import java.io.File;

/*
文件重命名
 */

public class rename {

    //读取文件
    public static String[] getFileName(String path) {
        File file = new File(path);
        String[] fileName = file.list();
        return fileName;
    }


    public static void renameFile(String path, String oldname, String newname) {
        if (!oldname.equals(newname)) {//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile = new File(path + "\\" + oldname);
            File newfile = new File(path + "\\" + newname);
            if (!oldfile.exists()) {
                return;//重命名文件不存在
            }
            if (newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                System.out.println(newname + "已经存在！");
            else {
                oldfile.renameTo(newfile);
            }
        } else {
            System.out.println("新文件名和旧文件名相同...");
        }

    }

    @Test
    public void main() {
        String a = "";
        String b = "";
        String D = "";
//        SQLCommandService ser = new SQLCommandService();
//        String sql = "select * from productmanager.it_microsthospital_doctor t where t.hospital_id=?";
//        ser.addParameter("8d87a8b0-9605-43fb-ad1a-571da32e320eEZZX");
//        List<Doctors> list = ser.getListBean(sql, Doctors.class);

//        for (Doctors y : list) {
//            System.out.println(y.getDOCTORNO() + "---" + y.getDOCTORNAME());
//        }

        String[] fileName = getFileName("D:\\源启掌上医院接口\\中山\\中山副本");//<span style="font-family: Arial, Helvetica, sans-serif;">此处修改为你的本地路径</span>
        for (int i = 0; i < fileName.length; i++) {
            a = fileName[i].replace(".png", ".jpg");
//            String c[] = a.split(".JPG");
//            b = c[0];
            b = a;
//            for (Doctors s : list) {
//                b = b.equals(s.getDOCTORNAME() + ".JPG") ? s.getDOCTORNO() + ".JPG" : b;
//
//
//            }


            System.out.println(b);
            renameFile("D:\\源启掌上医院接口\\中山\\中山副本", fileName[i], b);//cx修改为你要修改的文件名格式
        }
    }


    @Test
    public void py() {
        String a = "谁.jpg";
        System.out.println(getPingYin(a));


    }


    public static String getPingYin(String inputString) {

        //创建转换对象
        HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
        //转换类型（大写or小写）
        format.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        //定义中文声调的输出格式
        format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        //定义字符的输出格式
        format.setVCharType(HanyuPinyinVCharType.WITH_U_AND_COLON);

        //转换为字节数组
        char[] input = inputString.trim().toCharArray();
        // 用StringBuffer（字符串缓冲）来接收处理的数据
        StringBuffer output = new StringBuffer();

        try {
            for (int i = 0; i < input.length; i++) {
                //判断是否是一个汉子字符
                if (java.lang.Character.toString(input[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    String[] temp = PinyinHelper.toHanyuPinyinStringArray(input[i], format);
                    output.append(temp[0]);
                } else {
                    // 如果不是汉字字符，直接拼接
                    output.append(java.lang.Character.toString(input[i]));
                }
            }
        } catch (BadHanyuPinyinOutputFormatCombination e) {
            e.printStackTrace();
        }
        return output.toString();
    }


}



