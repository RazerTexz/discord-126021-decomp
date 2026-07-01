package androidx.exifinterface.media;

import android.util.Log;
import b.d.b.a.a;
import com.discord.widgets.chat.input.MentionUtilsKt;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: loaded from: classes.dex */
public class ExifInterface$ExifAttribute {
    public static final long BYTES_OFFSET_UNKNOWN = -1;
    public final byte[] bytes;
    public final long bytesOffset;
    public final int format;
    public final int numberOfComponents;

    public ExifInterface$ExifAttribute(int i, int i2, byte[] bArr) {
        this(i, i2, -1L, bArr);
    }

    public static ExifInterface$ExifAttribute createByte(String str) {
        if (str.length() == 1 && str.charAt(0) >= '0' && str.charAt(0) <= '1') {
            return new ExifInterface$ExifAttribute(1, 1, new byte[]{(byte) (str.charAt(0) - '0')});
        }
        byte[] bytes = str.getBytes(ExifInterface.ASCII);
        return new ExifInterface$ExifAttribute(1, bytes.length, bytes);
    }

    public static ExifInterface$ExifAttribute createDouble(double[] dArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[12] * dArr.length]);
        byteBufferWrap.order(byteOrder);
        for (double d : dArr) {
            byteBufferWrap.putDouble(d);
        }
        return new ExifInterface$ExifAttribute(12, dArr.length, byteBufferWrap.array());
    }

    public static ExifInterface$ExifAttribute createSLong(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[9] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putInt(i);
        }
        return new ExifInterface$ExifAttribute(9, iArr.length, byteBufferWrap.array());
    }

    public static ExifInterface$ExifAttribute createSRational(ExifInterface$Rational[] exifInterface$RationalArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[10] * exifInterface$RationalArr.length]);
        byteBufferWrap.order(byteOrder);
        for (ExifInterface$Rational exifInterface$Rational : exifInterface$RationalArr) {
            byteBufferWrap.putInt((int) exifInterface$Rational.numerator);
            byteBufferWrap.putInt((int) exifInterface$Rational.denominator);
        }
        return new ExifInterface$ExifAttribute(10, exifInterface$RationalArr.length, byteBufferWrap.array());
    }

    public static ExifInterface$ExifAttribute createString(String str) {
        byte[] bytes = (str + (char) 0).getBytes(ExifInterface.ASCII);
        return new ExifInterface$ExifAttribute(2, bytes.length, bytes);
    }

    public static ExifInterface$ExifAttribute createULong(long[] jArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[4] * jArr.length]);
        byteBufferWrap.order(byteOrder);
        for (long j : jArr) {
            byteBufferWrap.putInt((int) j);
        }
        return new ExifInterface$ExifAttribute(4, jArr.length, byteBufferWrap.array());
    }

    public static ExifInterface$ExifAttribute createURational(ExifInterface$Rational[] exifInterface$RationalArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[5] * exifInterface$RationalArr.length]);
        byteBufferWrap.order(byteOrder);
        for (ExifInterface$Rational exifInterface$Rational : exifInterface$RationalArr) {
            byteBufferWrap.putInt((int) exifInterface$Rational.numerator);
            byteBufferWrap.putInt((int) exifInterface$Rational.denominator);
        }
        return new ExifInterface$ExifAttribute(5, exifInterface$RationalArr.length, byteBufferWrap.array());
    }

    public static ExifInterface$ExifAttribute createUShort(int[] iArr, ByteOrder byteOrder) {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(new byte[ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[3] * iArr.length]);
        byteBufferWrap.order(byteOrder);
        for (int i : iArr) {
            byteBufferWrap.putShort((short) i);
        }
        return new ExifInterface$ExifAttribute(3, iArr.length, byteBufferWrap.array());
    }

    public double getDoubleValue(ByteOrder byteOrder) throws Throwable {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
        if (value instanceof String) {
            return Double.parseDouble((String) value);
        }
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            if (jArr.length == 1) {
                return jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            if (iArr.length == 1) {
                return iArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            if (dArr.length == 1) {
                return dArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(value instanceof ExifInterface$Rational[])) {
            throw new NumberFormatException("Couldn't find a double value");
        }
        ExifInterface$Rational[] exifInterface$RationalArr = (ExifInterface$Rational[]) value;
        if (exifInterface$RationalArr.length == 1) {
            return exifInterface$RationalArr[0].calculate();
        }
        throw new NumberFormatException("There are more than one component");
    }

    public int getIntValue(ByteOrder byteOrder) throws Throwable {
        Object value = getValue(byteOrder);
        if (value == null) {
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }
        if (value instanceof String) {
            return Integer.parseInt((String) value);
        }
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            if (jArr.length == 1) {
                return (int) jArr[0];
            }
            throw new NumberFormatException("There are more than one component");
        }
        if (!(value instanceof int[])) {
            throw new NumberFormatException("Couldn't find a integer value");
        }
        int[] iArr = (int[]) value;
        if (iArr.length == 1) {
            return iArr[0];
        }
        throw new NumberFormatException("There are more than one component");
    }

    public String getStringValue(ByteOrder byteOrder) throws Throwable {
        Object value = getValue(byteOrder);
        if (value == null) {
            return null;
        }
        if (value instanceof String) {
            return (String) value;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if (value instanceof long[]) {
            long[] jArr = (long[]) value;
            while (i < jArr.length) {
                sb.append(jArr[i]);
                i++;
                if (i != jArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (value instanceof int[]) {
            int[] iArr = (int[]) value;
            while (i < iArr.length) {
                sb.append(iArr[i]);
                i++;
                if (i != iArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (value instanceof double[]) {
            double[] dArr = (double[]) value;
            while (i < dArr.length) {
                sb.append(dArr[i]);
                i++;
                if (i != dArr.length) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
        if (!(value instanceof ExifInterface$Rational[])) {
            return null;
        }
        ExifInterface$Rational[] exifInterface$RationalArr = (ExifInterface$Rational[]) value;
        while (i < exifInterface$RationalArr.length) {
            sb.append(exifInterface$RationalArr[i].numerator);
            sb.append(MentionUtilsKt.SLASH_CHAR);
            sb.append(exifInterface$RationalArr[i].denominator);
            i++;
            if (i != exifInterface$RationalArr.length) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /* JADX WARN: Code duplicated, block: B:170:0x01a3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Not initialized variable reg: 3, insn: 0x01a0: MOVE (r2 I:??[OBJECT, ARRAY]) = (r3 I:??[OBJECT, ARRAY]), block:B:152:0x01a0 */
    public Object getValue(ByteOrder byteOrder) throws Throwable {
        ExifInterface$ByteOrderedDataInputStream exifInterface$ByteOrderedDataInputStream;
        InputStream inputStream;
        byte b2;
        byte[] bArr;
        InputStream inputStream2 = null;
        try {
            try {
                exifInterface$ByteOrderedDataInputStream = new ExifInterface$ByteOrderedDataInputStream(this.bytes);
                try {
                    exifInterface$ByteOrderedDataInputStream.setByteOrder(byteOrder);
                    boolean z2 = true;
                    int length = 0;
                    switch (this.format) {
                        case 1:
                        case 6:
                            byte[] bArr2 = this.bytes;
                            if (bArr2.length != 1 || bArr2[0] < 0 || bArr2[0] > 1) {
                                String str = new String(this.bytes, ExifInterface.ASCII);
                                try {
                                    exifInterface$ByteOrderedDataInputStream.close();
                                    break;
                                } catch (IOException e) {
                                    Log.e("ExifInterface", "IOException occurred while closing InputStream", e);
                                }
                                return str;
                            }
                            String str2 = new String(new char[]{(char) (this.bytes[0] + 48)});
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e2) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e2);
                            }
                            return str2;
                        case 2:
                        case 7:
                            if (this.numberOfComponents >= ExifInterface.EXIF_ASCII_PREFIX.length) {
                                int i = 0;
                                while (true) {
                                    bArr = ExifInterface.EXIF_ASCII_PREFIX;
                                    if (i < bArr.length) {
                                        if (this.bytes[i] != bArr[i]) {
                                            z2 = false;
                                        } else {
                                            i++;
                                        }
                                    }
                                }
                                if (z2) {
                                    length = bArr.length;
                                }
                            }
                            StringBuilder sb = new StringBuilder();
                            while (length < this.numberOfComponents && (b2 = this.bytes[length]) != 0) {
                                if (b2 >= 32) {
                                    sb.append((char) b2);
                                } else {
                                    sb.append('?');
                                }
                                length++;
                            }
                            String string = sb.toString();
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e3) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e3);
                            }
                            return string;
                        case 3:
                            int[] iArr = new int[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                iArr[length] = exifInterface$ByteOrderedDataInputStream.readUnsignedShort();
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e4) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e4);
                            }
                            return iArr;
                        case 4:
                            long[] jArr = new long[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                jArr[length] = exifInterface$ByteOrderedDataInputStream.readUnsignedInt();
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e5) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e5);
                            }
                            return jArr;
                        case 5:
                            ExifInterface$Rational[] exifInterface$RationalArr = new ExifInterface$Rational[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                exifInterface$RationalArr[length] = new ExifInterface$Rational(exifInterface$ByteOrderedDataInputStream.readUnsignedInt(), exifInterface$ByteOrderedDataInputStream.readUnsignedInt());
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e6) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e6);
                            }
                            return exifInterface$RationalArr;
                        case 8:
                            int[] iArr2 = new int[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                iArr2[length] = exifInterface$ByteOrderedDataInputStream.readShort();
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e7) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e7);
                            }
                            return iArr2;
                        case 9:
                            int[] iArr3 = new int[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                iArr3[length] = exifInterface$ByteOrderedDataInputStream.readInt();
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e8) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e8);
                            }
                            return iArr3;
                        case 10:
                            ExifInterface$Rational[] exifInterface$RationalArr2 = new ExifInterface$Rational[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                exifInterface$RationalArr2[length] = new ExifInterface$Rational(exifInterface$ByteOrderedDataInputStream.readInt(), exifInterface$ByteOrderedDataInputStream.readInt());
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e9) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e9);
                            }
                            return exifInterface$RationalArr2;
                        case 11:
                            double[] dArr = new double[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                dArr[length] = exifInterface$ByteOrderedDataInputStream.readFloat();
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e10) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e10);
                            }
                            return dArr;
                        case 12:
                            double[] dArr2 = new double[this.numberOfComponents];
                            while (length < this.numberOfComponents) {
                                dArr2[length] = exifInterface$ByteOrderedDataInputStream.readDouble();
                                length++;
                            }
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e11) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e11);
                            }
                            return dArr2;
                        default:
                            try {
                                exifInterface$ByteOrderedDataInputStream.close();
                                break;
                            } catch (IOException e12) {
                                Log.e("ExifInterface", "IOException occurred while closing InputStream", e12);
                            }
                            return null;
                    }
                } catch (IOException e13) {
                    e = e13;
                    Log.w("ExifInterface", "IOException occurred during reading a value", e);
                    if (exifInterface$ByteOrderedDataInputStream != null) {
                        try {
                            exifInterface$ByteOrderedDataInputStream.close();
                        } catch (IOException e14) {
                            Log.e("ExifInterface", "IOException occurred while closing InputStream", e14);
                        }
                    }
                    return null;
                }
            } catch (Throwable th) {
                th = th;
                inputStream2 = inputStream;
                if (inputStream2 != null) {
                    try {
                        inputStream2.close();
                    } catch (IOException e15) {
                        Log.e("ExifInterface", "IOException occurred while closing InputStream", e15);
                    }
                }
                throw th;
            }
        } catch (IOException e16) {
            e = e16;
            exifInterface$ByteOrderedDataInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            if (inputStream2 != null) {
                inputStream2.close();
            }
            throw th;
        }
    }

    public int size() {
        return ExifInterface.IFD_FORMAT_BYTES_PER_FORMAT[this.format] * this.numberOfComponents;
    }

    public String toString() {
        StringBuilder sbU = a.U("(");
        sbU.append(ExifInterface.IFD_FORMAT_NAMES[this.format]);
        sbU.append(", data length:");
        return a.B(sbU, this.bytes.length, ")");
    }

    public ExifInterface$ExifAttribute(int i, int i2, long j, byte[] bArr) {
        this.format = i;
        this.numberOfComponents = i2;
        this.bytesOffset = j;
        this.bytes = bArr;
    }

    public static ExifInterface$ExifAttribute createDouble(double d, ByteOrder byteOrder) {
        return createDouble(new double[]{d}, byteOrder);
    }

    public static ExifInterface$ExifAttribute createSLong(int i, ByteOrder byteOrder) {
        return createSLong(new int[]{i}, byteOrder);
    }

    public static ExifInterface$ExifAttribute createULong(long j, ByteOrder byteOrder) {
        return createULong(new long[]{j}, byteOrder);
    }

    public static ExifInterface$ExifAttribute createUShort(int i, ByteOrder byteOrder) {
        return createUShort(new int[]{i}, byteOrder);
    }

    public static ExifInterface$ExifAttribute createSRational(ExifInterface$Rational exifInterface$Rational, ByteOrder byteOrder) {
        return createSRational(new ExifInterface$Rational[]{exifInterface$Rational}, byteOrder);
    }

    public static ExifInterface$ExifAttribute createURational(ExifInterface$Rational exifInterface$Rational, ByteOrder byteOrder) {
        return createURational(new ExifInterface$Rational[]{exifInterface$Rational}, byteOrder);
    }
}
