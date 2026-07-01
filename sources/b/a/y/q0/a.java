package b.a.y.q0;

import com.discord.utilities.file.DownloadUtils$DownloadState;
import kotlin.Pair;
import rx.functions.Func2;

/* JADX INFO: compiled from: StickerView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T1, T2, R> implements Func2<DownloadUtils$DownloadState, Integer, Pair<? extends DownloadUtils$DownloadState, ? extends Integer>> {
    public static final a j = new a();

    @Override // rx.functions.Func2
    public Pair<? extends DownloadUtils$DownloadState, ? extends Integer> call(DownloadUtils$DownloadState downloadUtils$DownloadState, Integer num) {
        return new Pair<>(downloadUtils$DownloadState, num);
    }
}
