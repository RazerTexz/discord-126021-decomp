package b.g.a.b.o;

import androidx.recyclerview.widget.RecyclerView;
import b.g.a.b.JsonParser;
import java.math.BigDecimal;
import java.math.BigInteger;

/* JADX INFO: renamed from: b.g.a.b.o.b, reason: use source file name */
/* JADX INFO: compiled from: ParserMinimalBase.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ParserMinimalBase extends JsonParser {
    public static final BigInteger j;
    public static final BigInteger k;
    public static final BigInteger l;
    public static final BigInteger m;

    static {
        BigInteger bigIntegerValueOf = BigInteger.valueOf(-2147483648L);
        j = bigIntegerValueOf;
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(2147483647L);
        k = bigIntegerValueOf2;
        BigInteger bigIntegerValueOf3 = BigInteger.valueOf(Long.MIN_VALUE);
        l = bigIntegerValueOf3;
        BigInteger bigIntegerValueOf4 = BigInteger.valueOf(RecyclerView.FOREVER_NS);
        m = bigIntegerValueOf4;
        new BigDecimal(bigIntegerValueOf3);
        new BigDecimal(bigIntegerValueOf4);
        new BigDecimal(bigIntegerValueOf);
        new BigDecimal(bigIntegerValueOf2);
    }

    public ParserMinimalBase(int i) {
        super(i);
    }
}
