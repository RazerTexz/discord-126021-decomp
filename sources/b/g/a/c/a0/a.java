package b.g.a.c.a0;

import b.g.a.c.t;
import java.io.Serializable;

/* JADX INFO: compiled from: BasicDeserializerFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends f implements Serializable {
    public final b.g.a.c.z.j _factoryConfig;

    static {
        new t("@JsonUnwrapped");
    }

    public a(b.g.a.c.z.j jVar) {
        this._factoryConfig = jVar;
    }
}
