package lombok.installer;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: discord-126021.apk:lombok/installer/WindowsDriveInfo.SCL.lombok */
public class WindowsDriveInfo {
    private native int getLogicalDrives0();

    private native int getDriveType(String str);

    public List<String> getLogicalDrives() {
        int flags = getLogicalDrives0();
        List<String> letters = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if ((flags & (1 << i)) != 0) {
                letters.add(Character.toString((char) (65 + i)));
            }
        }
        return letters;
    }

    public boolean isFixedDisk(String letter) {
        if (letter.length() != 1) {
            throw new IllegalArgumentException("Supply 1 letter, not: " + letter);
        }
        char drive = Character.toUpperCase(letter.charAt(0));
        if (drive < 'A' || drive > 'Z') {
            throw new IllegalArgumentException("A drive is indicated by a letter, so A-Z inclusive. Not " + drive);
        }
        return ((long) getDriveType(new StringBuilder(String.valueOf(drive)).append(":\\").toString())) == 3;
    }

    public static void main(String[] args) {
        System.loadLibrary("WindowsDriveInfo");
        WindowsDriveInfo info = new WindowsDriveInfo();
        for (String letter : info.getLogicalDrives()) {
            PrintStream printStream = System.out;
            Object[] objArr = new Object[2];
            objArr[0] = letter;
            objArr[1] = info.isFixedDisk(letter) ? "Fixed Disk" : "Not Fixed Disk";
            printStream.printf("Drive %s: - %s\n", objArr);
        }
    }
}
