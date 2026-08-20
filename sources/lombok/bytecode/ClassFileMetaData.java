package lombok.bytecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: discord-126021.apk:lombok/bytecode/ClassFileMetaData.SCL.lombok */
public class ClassFileMetaData {
    private static final byte UTF8 = 1;
    private static final byte INTEGER = 3;
    private static final byte FLOAT = 4;
    private static final byte LONG = 5;
    private static final byte DOUBLE = 6;
    private static final byte CLASS = 7;
    private static final byte STRING = 8;
    private static final byte FIELD = 9;
    private static final byte METHOD = 10;
    private static final byte INTERFACE_METHOD = 11;
    private static final byte NAME_TYPE = 12;
    private static final byte METHOD_HANDLE = 15;
    private static final byte METHOD_TYPE = 16;
    private static final byte DYNAMIC = 17;
    private static final byte INVOKE_DYNAMIC = 18;
    private static final byte MODULE = 19;
    private static final byte PACKAGE = 20;
    private static final int NOT_FOUND = -1;
    private static final int START_OF_CONSTANT_POOL = 8;
    private final byte[] byteCode;
    private final int maxPoolSize = readValue(8);
    private final int[] offsets = new int[this.maxPoolSize];
    private final byte[] types = new byte[this.maxPoolSize];
    private final String[] utf8s = new String[this.maxPoolSize];
    private final int endOfPool;

    public ClassFileMetaData(byte[] byteCode) {
        this.byteCode = byteCode;
        int position = 10;
        int i = 1;
        while (i < this.maxPoolSize) {
            byte type = byteCode[position];
            this.types[i] = type;
            position++;
            this.offsets[i] = position;
            switch (type) {
                case 0:
                    break;
                case 1:
                    int length = readValue(position);
                    int position2 = position + 2;
                    this.utf8s[i] = decodeString(position2, length);
                    position = position2 + length;
                    break;
                case 2:
                case 13:
                case 14:
                default:
                    throw new AssertionError("Unknown constant pool type " + ((int) type));
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 17:
                case 18:
                    position += 4;
                    break;
                case 5:
                case 6:
                    position += 8;
                    i++;
                    break;
                case 7:
                case 8:
                case 16:
                case 19:
                case 20:
                    position += 2;
                    break;
                case 15:
                    position += 3;
                    break;
            }
            i++;
        }
        this.endOfPool = position;
    }

    private String decodeString(int pos, int size) {
        int end = pos + size;
        char[] result = new char[size];
        int length = 0;
        while (pos < end) {
            int i = pos;
            pos++;
            int first = this.byteCode[i] & 255;
            if (first < 128) {
                int i2 = length;
                length++;
                result[i2] = (char) first;
            } else if ((first & 224) == 192) {
                int x2 = (first & 31) << 6;
                pos++;
                int y2 = this.byteCode[pos] & 63;
                int i3 = length;
                length++;
                result[i3] = (char) (x2 | y2);
            } else {
                int x3 = (first & 15) << 12;
                int pos2 = pos + 1;
                int y3 = (this.byteCode[pos] & 63) << 6;
                pos = pos2 + 1;
                int z2 = this.byteCode[pos2] & 63;
                int i4 = length;
                length++;
                result[i4] = (char) (x3 | y3 | z2);
            }
        }
        return new String(result, 0, length);
    }

    public boolean containsUtf8(String value) {
        return findUtf8(value) != -1;
    }

    public boolean usesClass(String className) {
        return findClass(className) != -1;
    }

    public boolean usesField(String className, String fieldName) {
        int fieldNameIndex;
        int classIndex = findClass(className);
        if (classIndex == -1 || (fieldNameIndex = findUtf8(fieldName)) == -1) {
            return false;
        }
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 9 && readValue(this.offsets[i]) == classIndex) {
                int nameAndTypeIndex = readValue(this.offsets[i] + 2);
                if (readValue(this.offsets[nameAndTypeIndex]) == fieldNameIndex) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean usesMethod(String className, String methodName) {
        int methodNameIndex;
        int classIndex = findClass(className);
        if (classIndex == -1 || (methodNameIndex = findUtf8(methodName)) == -1) {
            return false;
        }
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (isMethod(i) && readValue(this.offsets[i]) == classIndex) {
                int nameAndTypeIndex = readValue(this.offsets[i] + 2);
                if (readValue(this.offsets[nameAndTypeIndex]) == methodNameIndex) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean usesMethod(String className, String methodName, String descriptor) {
        int nameAndTypeIndex;
        int classIndex = findClass(className);
        if (classIndex == -1 || (nameAndTypeIndex = findNameAndType(methodName, descriptor)) == -1) {
            return false;
        }
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (isMethod(i) && readValue(this.offsets[i]) == classIndex && readValue(this.offsets[i] + 2) == nameAndTypeIndex) {
                return true;
            }
        }
        return false;
    }

    public boolean containsStringConstant(String value) {
        int index = findUtf8(value);
        if (index == -1) {
            return false;
        }
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 8 && readValue(this.offsets[i]) == index) {
                return true;
            }
        }
        return false;
    }

    public boolean containsLong(long value) {
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 5 && readLong(i) == value) {
                return true;
            }
        }
        return false;
    }

    public boolean containsDouble(double value) {
        boolean isNan = Double.isNaN(value);
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 6) {
                double d = readDouble(i);
                if (d == value) {
                    return true;
                }
                if (isNan && Double.isNaN(d)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsInteger(int value) {
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 3 && readInteger(i) == value) {
                return true;
            }
        }
        return false;
    }

    public boolean containsFloat(float value) {
        boolean isNan = Float.isNaN(value);
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 4) {
                float f = readFloat(i);
                if (f == value) {
                    return true;
                }
                if (isNan && Float.isNaN(f)) {
                    return true;
                }
            }
        }
        return false;
    }

    private long readLong(int index) {
        int pos = this.offsets[index];
        return (((long) read32(pos)) << 32) | (((long) read32(pos + 4)) & 4294967295L);
    }

    private double readDouble(int index) {
        return Double.longBitsToDouble(readLong(index));
    }

    private int readInteger(int index) {
        return read32(this.offsets[index]);
    }

    private float readFloat(int index) {
        return Float.intBitsToFloat(readInteger(index));
    }

    private int read32(int pos) {
        return ((this.byteCode[pos] & 255) << 24) | ((this.byteCode[pos + 1] & 255) << 16) | ((this.byteCode[pos + 2] & 255) << 8) | (this.byteCode[pos + 3] & 255);
    }

    public String getClassName() {
        return getClassName(readValue(this.endOfPool + 2));
    }

    public String getSuperClassName() {
        return getClassName(readValue(this.endOfPool + 4));
    }

    public List<String> getInterfaces() {
        int size = readValue(this.endOfPool + 6);
        if (size == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            result.add(getClassName(readValue(this.endOfPool + 8 + (i * 2))));
        }
        return result;
    }

    public String poolContent() {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < this.maxPoolSize; i++) {
            result.append(String.format("#%02x: ", Integer.valueOf(i)));
            int pos = this.offsets[i];
            switch (this.types[i]) {
                case 0:
                    result.append("(cont.)");
                    break;
                case 1:
                    result.append("Utf8 ").append(this.utf8s[i]);
                    break;
                case 3:
                    result.append("int ").append(readInteger(i));
                    break;
                case 4:
                    result.append("float ").append(readFloat(i));
                    break;
                case 5:
                    result.append("long ").append(readLong(i));
                    break;
                case 6:
                    result.append("double ").append(readDouble(i));
                    break;
                case 7:
                    result.append("Class ").append(getClassName(i));
                    break;
                case 8:
                    result.append("String \"").append(this.utf8s[readValue(pos)]).append("\"");
                    break;
                case 9:
                    appendAccess(result.append("Field "), i);
                    break;
                case 10:
                case 11:
                    appendAccess(result.append("Method "), i);
                    break;
                case 12:
                    appendNameAndType(result.append("Name&Type "), i);
                    break;
                case 15:
                    result.append("MethodHandle...");
                    break;
                case 16:
                    result.append("MethodType...");
                    break;
                case 17:
                    result.append("Dynamic...");
                    break;
                case 18:
                    result.append("InvokeDynamic...");
                    break;
            }
            result.append("\n");
        }
        return result.toString();
    }

    private void appendAccess(StringBuilder result, int index) {
        int pos = this.offsets[index];
        result.append(getClassName(readValue(pos))).append(".");
        appendNameAndType(result, readValue(pos + 2));
    }

    private void appendNameAndType(StringBuilder result, int index) {
        int pos = this.offsets[index];
        result.append(this.utf8s[readValue(pos)]).append(":").append(this.utf8s[readValue(pos + 2)]);
    }

    private String getClassName(int classIndex) {
        if (classIndex < 1) {
            return null;
        }
        return this.utf8s[readValue(this.offsets[classIndex])];
    }

    private boolean isMethod(int i) {
        byte type = this.types[i];
        return type == 10 || type == 11;
    }

    private int findNameAndType(String name, String descriptor) {
        int descriptorIndex;
        int nameIndex = findUtf8(name);
        if (nameIndex == -1 || (descriptorIndex = findUtf8(descriptor)) == -1) {
            return -1;
        }
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 12 && readValue(this.offsets[i]) == nameIndex && readValue(this.offsets[i] + 2) == descriptorIndex) {
                return i;
            }
        }
        return -1;
    }

    private int findUtf8(String value) {
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (value.equals(this.utf8s[i])) {
                return i;
            }
        }
        return -1;
    }

    private int findClass(String className) {
        int index = findUtf8(className);
        if (index == -1) {
            return -1;
        }
        for (int i = 1; i < this.maxPoolSize; i++) {
            if (this.types[i] == 7 && readValue(this.offsets[i]) == index) {
                return i;
            }
        }
        return -1;
    }

    private int readValue(int position) {
        return ((this.byteCode[position] & 255) << 8) | (this.byteCode[position + 1] & 255);
    }
}
