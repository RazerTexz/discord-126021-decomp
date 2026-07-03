package p507d0.p579g0;

import kotlin.text.Regex;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: d0.g0.j */
/* JADX INFO: compiled from: StringNumberConversionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12093j {

    /* JADX INFO: renamed from: a */
    public static final Regex f25162a;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        sb.append("(\\p{Digit}+)");
        sb.append("(\\.)?(");
        sb.append("(\\p{Digit}+)");
        sb.append("?)(");
        C1643a.m876s0(sb, "[eE][+-]?(\\p{Digit}+)", ")?)|", "(\\.(", "(\\p{Digit}+)");
        C1643a.m876s0(sb, ")(", "[eE][+-]?(\\p{Digit}+)", ")?)|", "((");
        sb.append("(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))");
        sb.append(")[pP][+-]?");
        sb.append("(\\p{Digit}+)");
        sb.append(')');
        f25162a = new Regex(C1643a.m886y("[\\x00-\\x20]*[+-]?(NaN|Infinity|((", sb.toString(), ")[fFdD]?))[\\x00-\\x20]*"));
    }
}
