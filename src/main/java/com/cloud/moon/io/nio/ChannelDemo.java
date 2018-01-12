package com.cloud.moon.io.nio;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhangyubo02
 * create time : 2018/1/2.
 */
public class ChannelDemo {

    @Test
    public void testReadFileChannel() throws IOException {
        String classpath = this.getClass().getResource("/").getPath();
        File f = new File(classpath + "nio-data.txt");
        System.out.println(FileUtils.readFileToString(f, "utf-8"));
        try(RandomAccessFile file = new RandomAccessFile(f, "rw")) {
            FileChannel inChannel = file.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            // 1.从channel中读取到buffer里,返回的int值表示有多少字节被读到了buffer中,-1则表示到达了文件末尾
            int bytesRead = inChannel.read(byteBuffer);
            while (bytesRead != -1) {
                System.out.println("read " + bytesRead);
                // 2.状态翻转，之前是向buffer里写数据，现在是从buffer里读数据
                byteBuffer.flip();
                // 3.从buffer中读取数据
                while (byteBuffer.hasRemaining()) {
                    System.out.println((char) byteBuffer.get());
                }
                // 4.清空缓冲区，使其可以再次被写入 clear()会清空整个缓冲区，compact()只会清除已读过得缓冲区
                byteBuffer.clear();
                bytesRead = inChannel.read(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWriteFileChannel() {
        String classpath = this.getClass().getResource("/").getPath();
        File f = new File(classpath + "nio-data.txt");
        try(RandomAccessFile file = new RandomAccessFile(f, "rw")) {
            FileChannel fileChannel = file.getChannel();
            String data = "write new String";
            ByteBuffer byteBuffer = ByteBuffer.allocate(48);
            byteBuffer.put(data.getBytes());
            byteBuffer.flip();
            while (byteBuffer.hasRemaining()) {
                fileChannel.write(byteBuffer);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
