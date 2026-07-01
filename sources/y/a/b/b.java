package y.a.b;

import androidx.browser.trusted.TokenContents;
import java.util.Comparator;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class b implements Comparator {
    public static final /* synthetic */ b j = new b();

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return TokenContents.a((byte[]) obj, (byte[]) obj2);
    }
}
