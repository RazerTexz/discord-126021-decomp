package b.b.a;

import com.lytefast.flexinput.managers.FileManager;
import com.lytefast.flexinput.model.Attachment;
import com.lytefast.flexinput.utils.SelectionAggregator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: FlexInputCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface b<T> {
    SelectionAggregator<Attachment<T>> b();

    void f(Attachment<? extends T> attachment);

    FileManager getFileManager();

    boolean hasMediaPermissions();

    void requestMediaPermissions(Function0<Unit> function0);
}
