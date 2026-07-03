package p007b.p109f.p132g.p144g;

import android.content.Context;
import android.view.ViewConfiguration;
import androidx.annotation.VisibleForTesting;

/* JADX INFO: renamed from: b.f.g.g.a */
/* JADX INFO: compiled from: GestureDetector.java */
/* JADX INFO: loaded from: classes.dex */
public class C1797a {

    /* JADX INFO: renamed from: b */
    @VisibleForTesting
    public final float f3481b;

    /* JADX INFO: renamed from: e */
    @VisibleForTesting
    public long f3484e;

    /* JADX INFO: renamed from: f */
    @VisibleForTesting
    public float f3485f;

    /* JADX INFO: renamed from: g */
    @VisibleForTesting
    public float f3486g;

    /* JADX INFO: renamed from: a */
    @VisibleForTesting
    public a f3480a = null;

    /* JADX INFO: renamed from: c */
    @VisibleForTesting
    public boolean f3482c = false;

    /* JADX INFO: renamed from: d */
    @VisibleForTesting
    public boolean f3483d = false;

    /* JADX INFO: renamed from: b.f.g.g.a$a */
    /* JADX INFO: compiled from: GestureDetector.java */
    public interface a {
    }

    public C1797a(Context context) {
        this.f3481b = ViewConfiguration.get(context).getScaledTouchSlop();
    }
}
