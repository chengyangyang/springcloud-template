package com.sxmd.util;

import ch.qos.logback.core.util.FileUtil;
import lombok.extern.slf4j.Slf4j;

import java.io.*;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Description:  打包工具类
 *
 * @author cy
 * @date 2019年07月30日 21:15
 * version 1.0
 */
@Slf4j
public class ZipUtil {

    private ZipUtil() {
    }

    /**
     * 创建ZIP文件
     * @param sourcePath 文件或文件夹路径
     * @param zipPath 生成的zip文件存在路径（包括文件名）
     * @param isDrop  是否删除原文件:true删除、false不删除
     */
    public static boolean createZip(String sourcePath, String zipPath,Boolean isDrop) {
        boolean flag = true;
        try (
                FileOutputStream fos = new FileOutputStream(zipPath);
                ZipOutputStream zos = new ZipOutputStream(fos);
             ){
            writeZip(new File(sourcePath), "", zos,isDrop);
        } catch (Exception e) {
            flag = false;
            log.error("创建ZIP文件失败",e);
        }
        return flag;
    }
    /**
     * 清空文件和文件目录
     *
     * @param f
     */
    public static void clean(File f)  {
        String[] cs = f.list();
        if (cs == null || cs.length <= 0) {
            log.debug("delFile:[ " + f + " ]");
            try {
                Files.delete(f.toPath());
            } catch (IOException e) {
                log.error("delFile:[ " + f.getName() + "文件删除失败！" + " ]");
                throw new com.sxmd.exception.SxmdException(f.getName() + "文件删除失败！",e);
            }
        } else {
            for (int i = 0; i < cs.length; i++) {
                String cn = cs[i];
                String cp = f.getPath() + File.separator + cn;
                File f2 = new File(cp);
                if (f2.exists() && f2.isFile()) {
                    log.info("delFile:[ " + f2 + " ]");
                    try {
                        Files.delete(f2.toPath());
                    } catch (IOException e) {
                        log.warn("出错了",e);
                    }
                } else if (f2.exists() && f2.isDirectory()) {
                    clean(f2);
                }
            }
            try {
                Files.delete(f.toPath());
            } catch (IOException e) {
                throw new com.sxmd.exception.SxmdException(f.getName() + "文件删除失败！",e);
            }
        }
    }
    private static void writeZip(File file, String parentPath, ZipOutputStream zos,Boolean isDrop) {
        if(file.exists()){
            // 处理文件夹
            if(file.isDirectory()){
                parentPath+=file.getName()+File.separator;
                File [] files=file.listFiles();
                if(files.length > 0)
                {
                    for(File f:files){
                        writeZip(f, parentPath, zos,isDrop);
                    }
                } else {       //空目录则创建当前目录
                    try {
                        zos.putNextEntry(new ZipEntry(parentPath));
                    } catch (IOException e) {
                        log.warn("出现错误",e);
                    }
                }
            }else{
                FileInputStream fis=null;
                try {
                    fis=new FileInputStream(file);
                    ZipEntry ze = new ZipEntry(parentPath + file.getName());
                    zos.putNextEntry(ze);
                    byte [] content=new byte[1024];
                    int len;
                    while((len=fis.read(content))!=-1){
                        zos.write(content,0,len);
                        zos.flush();
                    }

                } catch (FileNotFoundException e) {
                    log.error("创建ZIP文件失败",e);
                } catch (IOException e) {
                    log.error("创建ZIP文件失败",e);
                }finally{
                    try {
                        if(fis!=null){
                            fis.close();
                        }
                        if(isDrop){
                            clean(file);
                        }
                    }catch(IOException e){
                        log.error("创建ZIP文件失败",e);
                    } catch (Exception e) {
                        log.warn("出现错误",e);
                    }
                }
            }
        }
    }

}
