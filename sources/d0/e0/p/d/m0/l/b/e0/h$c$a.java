package d0.e0.p.d.m0.l.b.e0;

import d0.e0.p.d.m0.i.p;
import d0.z.d.o;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [M] */
/* JADX INFO: compiled from: DeserializedMemberScope.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h$c$a<M> extends o implements Function0<M> {
    public final /* synthetic */ ByteArrayInputStream $inputStream;
    public final /* synthetic */ p<M> $parser;
    public final /* synthetic */ h this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h$c$a(p<M> pVar, ByteArrayInputStream byteArrayInputStream, h hVar) {
        super(0);
        this.$parser = pVar;
        this.$inputStream = byteArrayInputStream;
        this.this$0 = hVar;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Object invoke() {
        return invoke();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TM; */
    @Override // kotlin.jvm.functions.Function0
    public final d0.e0.p.d.m0.i.n invoke() {
        return (d0.e0.p.d.m0.i.n) ((d0.e0.p.d.m0.i.b) this.$parser).m89parseDelimitedFrom((InputStream) this.$inputStream, this.this$0.c.getComponents().getExtensionRegistryLite());
    }
}
