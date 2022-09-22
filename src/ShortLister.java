import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;

import static java.nio.file.StandardOpenOption.CREATE;

public class ShortLister
{
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<String> shortWords = new ArrayList<>();
        ShortWordFilter shortFilter = new ShortWordFilter();
        String words = "";
        try
        {
            File inFile;
            Path target = new File(System.getProperty("user.dir")).toPath();
            target = target.resolve("src");
            chooser.setCurrentDirectory(target.toFile());

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();
                InputStream input = new BufferedInputStream(Files.newInputStream(target, CREATE));
                BufferedReader buffRead = new BufferedReader(new InputStreamReader(input));
                String[] array;
                while (buffRead.ready())
                {
                    words = buffRead.readLine();
                    array = words.split("[^\\w']");
                    for(String i : array)
                    {
                        stringList.add(i);
                    }
                }
            }
            else
            {
                System.out.println("You must select a file.  The program will now close.");
                System.exit(0);
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found error");
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        for(Object x : stringList)
        {
            if (shortFilter.accept(x))
            {
                System.out.println(x + " ");
            }
        }
    }
}
