package p007b.p225i.p226a.p288f.p292c.p293a.p296f;

import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.Comparator;

/* JADX INFO: renamed from: b.i.a.f.c.a.f.c */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class C3218c implements Comparator {

    /* JADX INFO: renamed from: j */
    public static final Comparator f9241j = new C3218c();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        Parcelable.Creator<GoogleSignInAccount> creator = GoogleSignInAccount.CREATOR;
        return ((Scope) obj).f20488k.compareTo(((Scope) obj2).f20488k);
    }
}
