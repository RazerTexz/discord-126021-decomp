package b.i.c.m.d.p;

import java.io.IOException;

/* JADX INFO: compiled from: CodedOutputStream.java */
/* JADX INFO: loaded from: classes3.dex */
public class c$a extends IOException {
    private static final long serialVersionUID = -6947486886997889499L;

    public c$a() {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.");
    }
}
