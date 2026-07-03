package p007b.p100d.p104b.p105a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelProvider;
import androidx.view.ViewModelStore;
import com.discord.api.channel.Channel;
import com.discord.models.domain.Model;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.esotericsoftware.kryo.KryoException;
import com.google.android.exoplayer2.ParserException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;
import p007b.p008a.p009a.p011a0.C0805c;
import p007b.p008a.p025i.C1007m4;
import p007b.p008a.p041q.p047o0.C1256e;
import p007b.p225i.p361c.p369m.p370d.C4592b;
import p507d0.C12116o;
import p507d0.p513e0.InterfaceC11234g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.p570n1.InterfaceC11980i;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12237l;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.C12250y;
import p617h0.p618a.p619a.C12414c;
import p617h0.p618a.p619a.C12433v;

/* JADX INFO: renamed from: b.d.b.a.a */
/* JADX INFO: compiled from: outline */
/* JADX INFO: loaded from: classes.dex */
public class C1643a {
    /* JADX INFO: renamed from: A */
    public static String m813A(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: B */
    public static String m814B(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: C */
    public static String m815C(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: D */
    public static String m816D(StringBuilder sb, Boolean bool, String str) {
        sb.append(bool);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: E */
    public static String m817E(StringBuilder sb, CharSequence charSequence, String str) {
        sb.append(charSequence);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: F */
    public static String m818F(StringBuilder sb, Integer num, String str) {
        sb.append(num);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: G */
    public static String m819G(StringBuilder sb, Long l, String str) {
        sb.append(l);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: H */
    public static String m820H(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    /* JADX INFO: renamed from: I */
    public static Context m821I(TextView textView, String str, String str2) {
        C12238m.checkNotNullExpressionValue(textView, str);
        Context context = textView.getContext();
        C12238m.checkNotNullExpressionValue(context, str2);
        return context;
    }

    /* JADX INFO: renamed from: J */
    public static String m822J(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: K */
    public static String m823K(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* JADX INFO: renamed from: L */
    public static String m824L(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: M */
    public static String m825M(StringBuilder sb, Map map, String str) {
        sb.append(map);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: N */
    public static String m826N(StringBuilder sb, Set set, String str) {
        sb.append(set);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: O */
    public static String m827O(StringBuilder sb, boolean z2, String str) {
        sb.append(z2);
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: P */
    public static String m828P(Object[] objArr, int i, String str, String str2) {
        String str3 = String.format(str, Arrays.copyOf(objArr, i));
        C12238m.checkNotNullExpressionValue(str3, str2);
        return str3;
    }

    /* JADX INFO: renamed from: Q */
    public static StringBuilder m829Q(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    /* JADX INFO: renamed from: R */
    public static StringBuilder m830R(int i, String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: S */
    public static StringBuilder m831S(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    /* JADX INFO: renamed from: T */
    public static Bundle m832T(String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(str, j);
        return bundle;
    }

    /* JADX INFO: renamed from: U */
    public static StringBuilder m833U(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    /* JADX INFO: renamed from: V */
    public static StringBuilder m834V(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: W */
    public static StringBuilder m835W(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: X */
    public static StringBuilder m836X(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: Y */
    public static StringBuilder m837Y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    /* JADX INFO: renamed from: Z */
    public static StringBuilder m838Z(String str, InterfaceC11980i interfaceC11980i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(interfaceC11980i);
        sb.append(str2);
        return sb;
    }

    /* JADX INFO: renamed from: a */
    public static float m839a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    /* JADX INFO: renamed from: a0 */
    public static ArrayList m840a0(List list, String str) {
        C12238m.checkNotNullExpressionValue(list, str);
        return new ArrayList();
    }

    /* JADX INFO: renamed from: b */
    public static int m841b(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    /* JADX INFO: renamed from: b0 */
    public static Pair m842b0(C1256e.b bVar, Float f, String str) {
        return C12116o.m10073to(str, Long.valueOf(C1256e.b.m359a(bVar, f)));
    }

    /* JADX INFO: renamed from: c */
    public static Object m843c(Channel channel, Map map) {
        return map.get(Long.valueOf(channel.getGuildId()));
    }

    /* JADX INFO: renamed from: c0 */
    public static Ref$ObjectRef m844c0(Model.JsonReader jsonReader, String str) {
        C12238m.checkNotNullParameter(jsonReader, str);
        return new Ref$ObjectRef();
    }

    /* JADX INFO: renamed from: d */
    public static Object m845d(Channel channel, Map map) {
        return map.get(Long.valueOf(channel.getId()));
    }

    /* JADX INFO: renamed from: d0 */
    public static InterfaceC11234g m846d0(Class cls, String str, String str2, int i) {
        return C12216a0.property1(new C12250y(cls, str, str2, i));
    }

    /* JADX INFO: renamed from: e */
    public static Object m847e(Guild guild, Map map) {
        return map.get(Long.valueOf(guild.getId()));
    }

    /* JADX INFO: renamed from: e0 */
    public static ViewModelProvider.Factory m848e0(Fragment fragment, String str) {
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, str);
        return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
    }

    /* JADX INFO: renamed from: f */
    public static Object m849f(User user, Map map) {
        return map.get(Long.valueOf(user.getId()));
    }

    /* JADX INFO: renamed from: f0 */
    public static void m850f0(int i, Canvas canvas, int i2, int i3) {
        C12237l.finallyStart(i);
        canvas.restoreToCount(i2);
        C12237l.finallyEnd(i3);
    }

    /* JADX INFO: renamed from: g */
    public static String m851g(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: g0 */
    public static void m852g0(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        Log.w(str2, sb.toString());
    }

    /* JADX INFO: renamed from: h */
    public static String m853h(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    /* JADX INFO: renamed from: h0 */
    public static void m854h0(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        Log.w(str3, sb.toString());
    }

    /* JADX INFO: renamed from: i */
    public static String m855i(int i, String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: i0 */
    public static void m856i0(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.w(str4, sb.toString());
    }

    /* JADX INFO: renamed from: j */
    public static String m857j(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: j0 */
    public static void m858j0(int i, HashMap map, String str, int i2, String str2, int i3, String str3, int i4, String str4) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
        map.put(str3, Integer.valueOf(i3));
        map.put(str4, Integer.valueOf(i4));
    }

    /* JADX INFO: renamed from: k */
    public static String m859k(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    /* JADX INFO: renamed from: k0 */
    public static void m860k0(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    /* JADX INFO: renamed from: l */
    public static String m861l(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    /* JADX INFO: renamed from: l0 */
    public static void m862l0(Class cls, StringBuilder sb, String str) {
        sb.append(C12216a0.getOrCreateKotlinClass(cls).getSimpleName());
        sb.append(str);
    }

    /* JADX INFO: renamed from: m */
    public static int m863m(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    /* JADX INFO: renamed from: m0 */
    public static void m864m0(Class cls, StringBuilder sb, String str, KryoException kryoException) {
        sb.append(cls.getName());
        sb.append(str);
        kryoException.addTrace(sb.toString());
    }

    /* JADX INFO: renamed from: n */
    public static String m865n(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    /* JADX INFO: renamed from: n0 */
    public static void m866n0(String str, int i, String str2) {
        Log.d(str2, str + i);
    }

    /* JADX INFO: renamed from: o */
    public static String m867o(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    /* JADX INFO: renamed from: o0 */
    public static void m868o0(String str, String str2, C4592b c4592b) {
        c4592b.m6371b(str + str2);
    }

    /* JADX INFO: renamed from: p */
    public static String m869p(Class cls, StringBuilder sb, String str, String str2) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        sb.append(cls.getSimpleName());
        sb.append(str2);
        return sb.toString();
    }

    /* JADX INFO: renamed from: p0 */
    public static ViewModelStore m870p0(Fragment fragment, String str, String str2) {
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        C12238m.checkNotNullExpressionValue(fragmentActivityRequireActivity, str);
        ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
        C12238m.checkNotNullExpressionValue(viewModelStore, str2);
        return viewModelStore;
    }

    /* JADX INFO: renamed from: q */
    public static String m871q(String str, int i) {
        return str + i;
    }

    /* JADX INFO: renamed from: q0 */
    public static void m872q0(String str, String str2, String str3, String str4, String str5, String str6) {
        C12238m.checkNotNullParameter(str, str2);
        C12238m.checkNotNullParameter(str3, str4);
        C12238m.checkNotNullParameter(str5, str6);
    }

    /* JADX INFO: renamed from: r */
    public static String m873r(String str, int i, String str2) {
        return str + i + str2;
    }

    /* JADX INFO: renamed from: r0 */
    public static void m874r0(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.w(str2, sb.toString());
    }

    /* JADX INFO: renamed from: s */
    public static String m875s(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    /* JADX INFO: renamed from: s0 */
    public static void m876s0(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    /* JADX INFO: renamed from: t */
    public static String m877t(String str, long j) {
        return str + j;
    }

    /* JADX INFO: renamed from: t0 */
    public static void m878t0(C12433v c12433v, String str, C12414c c12414c, int i) {
        c12414c.m10538j(c12433v.m10637l(str));
        c12414c.m10537i(i);
    }

    /* JADX INFO: renamed from: u */
    public static String m879u(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    /* JADX INFO: renamed from: u0 */
    public static boolean m880u0(C11703b.b bVar, int i, String str) {
        Boolean bool = bVar.get(i);
        C12238m.checkNotNullExpressionValue(bool, str);
        return bool.booleanValue();
    }

    /* JADX INFO: renamed from: v */
    public static String m881v(String str, Object obj) {
        return str + obj;
    }

    /* JADX INFO: renamed from: v0 */
    public static C1007m4 m882v0(TextView textView, String str, CharSequence charSequence, C0805c c0805c) {
        C12238m.checkNotNullExpressionValue(textView, str);
        textView.setText(charSequence);
        return c0805c.m105h();
    }

    /* JADX INFO: renamed from: w */
    public static String m883w(String str, String str2) {
        return str + str2;
    }

    /* JADX INFO: renamed from: w0 */
    public static ParserException m884w0(int i, String str, int i2, Throwable th) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return ParserException.m8755a(sb.toString(), th);
    }

    /* JADX INFO: renamed from: x */
    public static Context m885x(View view, String str, String str2) {
        C12238m.checkNotNullExpressionValue(view, str);
        Context context = view.getContext();
        C12238m.checkNotNullExpressionValue(context, str2);
        return context;
    }

    /* JADX INFO: renamed from: y */
    public static String m886y(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    /* JADX INFO: renamed from: z */
    public static String m887z(String str, Type type) {
        return str + type;
    }
}
