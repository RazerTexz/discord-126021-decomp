package com.google.android.exoplayer2.audio;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import b.i.a.c.t2.o;
import b.i.a.c.t2.u;
import b.i.a.c.x1;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes3.dex */
public interface AudioSink {
    boolean a(j1 j1Var);

    boolean b();

    x1 c();

    void d();

    void e();

    void flush();

    void i(x1 x1Var);

    void j() throws AudioSink$WriteException;

    boolean k();

    void l(int i);

    long m(boolean z2);

    void n();

    void o(o oVar);

    void p();

    void q(float f);

    void r();

    void reset();

    boolean s(ByteBuffer byteBuffer, long j, int i) throws AudioSink$WriteException, AudioSink$InitializationException;

    void t(AudioSink$a audioSink$a);

    int u(j1 j1Var);

    void v(j1 j1Var, int i, @Nullable int[] iArr) throws AudioSink$ConfigurationException;

    void w(boolean z2);

    void x(u uVar);
}
