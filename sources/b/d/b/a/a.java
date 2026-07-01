package b.d.b.a;

import android.content.Context;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.view.ViewModelProvider$Factory;
import androidx.view.ViewModelStore;
import b.a.i.m4;
import b.a.q.o0.e$b;
import b.i.c.m.d.b;
import com.discord.api.channel.Channel;
import com.discord.models.domain.Model$JsonReader;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.esotericsoftware.kryo.KryoException;
import com.google.android.exoplayer2.ParserException;
import d0.e0.g;
import d0.e0.p.d.m0.f.z.b$b;
import d0.e0.p.d.m0.n.n1.i;
import d0.o;
import d0.z.d.a0;
import d0.z.d.l;
import d0.z.d.m;
import d0.z.d.y;
import h0.a.a.c;
import h0.a.a.v;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.internal.Ref$ObjectRef;

/* JADX INFO: compiled from: outline */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public static String A(StringBuilder sb, int i, char c) {
        sb.append(i);
        sb.append(c);
        return sb.toString();
    }

    public static String B(StringBuilder sb, int i, String str) {
        sb.append(i);
        sb.append(str);
        return sb.toString();
    }

    public static String C(StringBuilder sb, long j, String str) {
        sb.append(j);
        sb.append(str);
        return sb.toString();
    }

    public static String D(StringBuilder sb, Boolean bool, String str) {
        sb.append(bool);
        sb.append(str);
        return sb.toString();
    }

    public static String E(StringBuilder sb, CharSequence charSequence, String str) {
        sb.append(charSequence);
        sb.append(str);
        return sb.toString();
    }

    public static String F(StringBuilder sb, Integer num, String str) {
        sb.append(num);
        sb.append(str);
        return sb.toString();
    }

    public static String G(StringBuilder sb, Long l, String str) {
        sb.append(l);
        sb.append(str);
        return sb.toString();
    }

    public static String H(StringBuilder sb, String str, char c) {
        sb.append(str);
        sb.append(c);
        return sb.toString();
    }

    public static Context I(TextView textView, String str, String str2) {
        m.checkNotNullExpressionValue(textView, str);
        Context context = textView.getContext();
        m.checkNotNullExpressionValue(context, str2);
        return context;
    }

    public static String J(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static String K(StringBuilder sb, String str, String str2, String str3) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static String L(StringBuilder sb, List list, String str) {
        sb.append(list);
        sb.append(str);
        return sb.toString();
    }

    public static String M(StringBuilder sb, Map map, String str) {
        sb.append(map);
        sb.append(str);
        return sb.toString();
    }

    public static String N(StringBuilder sb, Set set, String str) {
        sb.append(set);
        sb.append(str);
        return sb.toString();
    }

    public static String O(StringBuilder sb, boolean z2, String str) {
        sb.append(z2);
        sb.append(str);
        return sb.toString();
    }

    public static String P(Object[] objArr, int i, String str, String str2) {
        String str3 = String.format(str, Arrays.copyOf(objArr, i));
        m.checkNotNullExpressionValue(str3, str2);
        return str3;
    }

    public static StringBuilder Q(char c) {
        StringBuilder sb = new StringBuilder();
        sb.append(c);
        return sb;
    }

    public static StringBuilder R(int i, String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder S(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb;
    }

    public static Bundle T(String str, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong(str, j);
        return bundle;
    }

    public static StringBuilder U(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        return sb;
    }

    public static StringBuilder V(String str, int i, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder W(String str, int i, String str2, int i2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(i);
        sb.append(str2);
        sb.append(i2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder X(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        return sb;
    }

    public static StringBuilder Y(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb;
    }

    public static StringBuilder Z(String str, i iVar, String str2) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(iVar);
        sb.append(str2);
        return sb;
    }

    public static float a(float f, float f2, float f3, float f4) {
        return ((f - f2) * f3) + f4;
    }

    public static ArrayList a0(List list, String str) {
        m.checkNotNullExpressionValue(list, str);
        return new ArrayList();
    }

    public static int b(String str, int i) {
        return String.valueOf(str).length() + i;
    }

    public static Pair b0(e$b e_b, Float f, String str) {
        return o.to(str, Long.valueOf(e$b.a(e_b, f)));
    }

    public static Object c(Channel channel, Map map) {
        return map.get(Long.valueOf(channel.getGuildId()));
    }

    public static Ref$ObjectRef c0(Model$JsonReader model$JsonReader, String str) {
        m.checkNotNullParameter(model$JsonReader, str);
        return new Ref$ObjectRef();
    }

    public static Object d(Channel channel, Map map) {
        return map.get(Long.valueOf(channel.getId()));
    }

    public static g d0(Class cls, String str, String str2, int i) {
        return a0.property1(new y(cls, str, str2, i));
    }

    public static Object e(Guild guild, Map map) {
        return map.get(Long.valueOf(guild.getId()));
    }

    public static ViewModelProvider$Factory e0(Fragment fragment, String str) {
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, str);
        return fragmentActivityRequireActivity.getDefaultViewModelProviderFactory();
    }

    public static Object f(User user, Map map) {
        return map.get(Long.valueOf(user.getId()));
    }

    public static void f0(int i, Canvas canvas, int i2, int i3) {
        l.finallyStart(i);
        canvas.restoreToCount(i2);
        l.finallyEnd(i3);
    }

    public static String g(int i, String str, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return sb.toString();
    }

    public static void g0(int i, String str, int i2, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        Log.w(str2, sb.toString());
    }

    public static String h(int i, String str, int i2, String str2, int i3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        sb.append(str2);
        sb.append(i3);
        return sb.toString();
    }

    public static void h0(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        Log.w(str3, sb.toString());
    }

    public static String i(int i, String str, long j, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(j);
        sb.append(str2);
        return sb.toString();
    }

    public static void i0(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        Log.w(str4, sb.toString());
    }

    public static String j(int i, String str, String str2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        return sb.toString();
    }

    public static void j0(int i, HashMap map, String str, int i2, String str2, int i3, String str3, int i4, String str4) {
        map.put(str, Integer.valueOf(i));
        map.put(str2, Integer.valueOf(i2));
        map.put(str3, Integer.valueOf(i3));
        map.put(str4, Integer.valueOf(i4));
    }

    public static String k(int i, String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        return sb.toString();
    }

    public static void k0(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
    }

    public static String l(int i, String str, String str2, String str3, String str4) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
        return sb.toString();
    }

    public static void l0(Class cls, StringBuilder sb, String str) {
        sb.append(a0.getOrCreateKotlinClass(cls).getSimpleName());
        sb.append(str);
    }

    public static int m(String str, int i, int i2) {
        return (str.hashCode() + i) * i2;
    }

    public static void m0(Class cls, StringBuilder sb, String str, KryoException kryoException) {
        sb.append(cls.getName());
        sb.append(str);
        kryoException.addTrace(sb.toString());
    }

    public static String n(RecyclerView recyclerView, StringBuilder sb) {
        sb.append(recyclerView.exceptionLabel());
        return sb.toString();
    }

    public static void n0(String str, int i, String str2) {
        Log.d(str2, str + i);
    }

    public static String o(Class cls, StringBuilder sb, String str) {
        sb.append(cls.getName());
        sb.append(str);
        return sb.toString();
    }

    public static void o0(String str, String str2, b bVar) {
        bVar.b(str + str2);
    }

    public static String p(Class cls, StringBuilder sb, String str, String str2) {
        sb.append(cls.getSimpleName());
        sb.append(str);
        sb.append(cls.getSimpleName());
        sb.append(str2);
        return sb.toString();
    }

    public static ViewModelStore p0(Fragment fragment, String str, String str2) {
        FragmentActivity fragmentActivityRequireActivity = fragment.requireActivity();
        m.checkNotNullExpressionValue(fragmentActivityRequireActivity, str);
        ViewModelStore viewModelStore = fragmentActivityRequireActivity.getViewModelStore();
        m.checkNotNullExpressionValue(viewModelStore, str2);
        return viewModelStore;
    }

    public static String q(String str, int i) {
        return str + i;
    }

    public static void q0(String str, String str2, String str3, String str4, String str5, String str6) {
        m.checkNotNullParameter(str, str2);
        m.checkNotNullParameter(str3, str4);
        m.checkNotNullParameter(str5, str6);
    }

    public static String r(String str, int i, String str2) {
        return str + i + str2;
    }

    public static void r0(StringBuilder sb, String str, String str2) {
        sb.append(str);
        Log.w(str2, sb.toString());
    }

    public static String s(String str, int i, String str2, int i2) {
        return str + i + str2 + i2;
    }

    public static void s0(StringBuilder sb, String str, String str2, String str3, String str4) {
        sb.append(str);
        sb.append(str2);
        sb.append(str3);
        sb.append(str4);
    }

    public static String t(String str, long j) {
        return str + j;
    }

    public static void t0(v vVar, String str, c cVar, int i) {
        cVar.j(vVar.l(str));
        cVar.i(i);
    }

    public static String u(String str, Fragment fragment, String str2) {
        return str + fragment + str2;
    }

    public static boolean u0(b$b b_b, int i, String str) {
        Boolean bool = b_b.get(i);
        m.checkNotNullExpressionValue(bool, str);
        return bool.booleanValue();
    }

    public static String v(String str, Object obj) {
        return str + obj;
    }

    public static m4 v0(TextView textView, String str, CharSequence charSequence, b.a.a.a0.c cVar) {
        m.checkNotNullExpressionValue(textView, str);
        textView.setText(charSequence);
        return cVar.h();
    }

    public static String w(String str, String str2) {
        return str + str2;
    }

    public static ParserException w0(int i, String str, int i2, Throwable th) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(str);
        sb.append(i2);
        return ParserException.a(sb.toString(), th);
    }

    public static Context x(View view, String str, String str2) {
        m.checkNotNullExpressionValue(view, str);
        Context context = view.getContext();
        m.checkNotNullExpressionValue(context, str2);
        return context;
    }

    public static String y(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String z(String str, Type type) {
        return str + type;
    }
}
