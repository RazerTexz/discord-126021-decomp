package p007b.p225i.p226a.p228b;

import androidx.annotation.Nullable;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.b.a */
/* JADX INFO: compiled from: AutoValue_Event.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2406a<T> extends AbstractC2408c<T> {

    /* JADX INFO: renamed from: a */
    public final T f5116a;

    /* JADX INFO: renamed from: b */
    public final EnumC2409d f5117b;

    public C2406a(@Nullable Integer num, T t, EnumC2409d enumC2409d) {
        Objects.requireNonNull(t, "Null payload");
        this.f5116a = t;
        Objects.requireNonNull(enumC2409d, "Null priority");
        this.f5117b = enumC2409d;
    }

    @Override // p007b.p225i.p226a.p228b.AbstractC2408c
    @Nullable
    /* JADX INFO: renamed from: a */
    public Integer mo2286a() {
        return null;
    }

    @Override // p007b.p225i.p226a.p228b.AbstractC2408c
    /* JADX INFO: renamed from: b */
    public T mo2287b() {
        return this.f5116a;
    }

    @Override // p007b.p225i.p226a.p228b.AbstractC2408c
    /* JADX INFO: renamed from: c */
    public EnumC2409d mo2288c() {
        return this.f5117b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2408c)) {
            return false;
        }
        AbstractC2408c abstractC2408c = (AbstractC2408c) obj;
        return abstractC2408c.mo2286a() == null && this.f5116a.equals(abstractC2408c.mo2287b()) && this.f5117b.equals(abstractC2408c.mo2288c());
    }

    public int hashCode() {
        return this.f5117b.hashCode() ^ (((-721379959) ^ this.f5116a.hashCode()) * 1000003);
    }

    public String toString() {
        return "Event{code=" + ((Object) null) + ", payload=" + this.f5116a + ", priority=" + this.f5117b + "}";
    }
}
