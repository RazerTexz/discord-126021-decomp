package b.i.a.f.h.l;

import b.i.a.f.h.l.u4;
import b.i.a.f.h.l.u4$b;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzkq;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class u4$b<MessageType extends u4<MessageType, BuilderType>, BuilderType extends u4$b<MessageType, BuilderType>> extends n3<MessageType, BuilderType> {
    public final MessageType j;
    public MessageType k;
    public boolean l = false;

    public u4$b(MessageType messagetype) {
        this.j = messagetype;
        this.k = (MessageType) messagetype.p(4, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Object clone() throws CloneNotSupportedException {
        u4$b u4_b = (u4$b) this.j.p(5, null, null);
        u4_b.l((u4) o());
        return u4_b;
    }

    @Override // b.i.a.f.h.l.d6
    public final /* synthetic */ c6 k() {
        return this.j;
    }

    public final BuilderType l(MessageType messagetype) {
        if (this.l) {
            n();
            this.l = false;
        }
        MessageType messagetype2 = this.k;
        n6.a.b(messagetype2).i(messagetype2, messagetype);
        return this;
    }

    public final u4$b m(byte[] bArr, int i, h4 h4Var) throws zzij {
        if (this.l) {
            n();
            this.l = false;
        }
        try {
            n6.a.b(this.k).h(this.k, bArr, 0, i, new s3(h4Var));
            return this;
        } catch (zzij e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzij.a();
        }
    }

    public void n() {
        MessageType messagetype = (MessageType) this.k.p(4, null, null);
        n6.a.b(messagetype).i(messagetype, this.k);
        this.k = messagetype;
    }

    public c6 o() {
        if (this.l) {
            return this.k;
        }
        MessageType messagetype = this.k;
        n6.a.b(messagetype).d(messagetype);
        this.l = true;
        return this.k;
    }

    public c6 p() {
        u4 u4Var = (u4) o();
        if (u4Var.j()) {
            return u4Var;
        }
        throw new zzkq();
    }
}
