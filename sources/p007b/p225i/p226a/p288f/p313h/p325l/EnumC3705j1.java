package p007b.p225i.p226a.p288f.p313h.p325l;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: renamed from: b.i.a.f.h.l.j1 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public enum EnumC3705j1 implements InterfaceC3903y4 {
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN(0),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED(1),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED(2),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED(3),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED(4),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED(5);

    private final int zzh;

    EnumC3705j1(int i) {
        this.zzh = i;
    }

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3903y4
    /* JADX INFO: renamed from: a */
    public final int mo4875a() {
        return this.zzh;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "<" + EnumC3705j1.class.getName() + MentionUtilsKt.MENTIONS_CHAR + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzh + " name=" + name() + '>';
    }
}
