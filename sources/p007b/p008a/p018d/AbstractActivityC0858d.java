package p007b.p008a.p018d;

import com.discord.app.AppTransitionActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.d.d */
/* JADX INFO: compiled from: AppEventHandlerActivity.kt */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractActivityC0858d extends AppTransitionActivity {

    /* JADX INFO: renamed from: l */
    public final TreeMap<Integer, HashMap<String, Function0<Boolean>>> f505l = new TreeMap<>();

    @Override // com.discord.app.AppTransitionActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() throws Exception {
        boolean z2;
        Collection<HashMap<String, Function0<Boolean>>> collectionValues = this.f505l.values();
        C12238m.checkNotNullExpressionValue(collectionValues, "backPressHandlers\n        .values");
        Iterator<T> it = collectionValues.iterator();
        loop0: while (true) {
            if (!it.hasNext()) {
                z2 = false;
                break;
            }
            Collection collectionValues2 = ((HashMap) it.next()).values();
            C12238m.checkNotNullExpressionValue(collectionValues2, "handlers\n              .values");
            Iterator it2 = collectionValues2.iterator();
            while (it2.hasNext()) {
                if (((Boolean) ((Function0) it2.next()).invoke()).booleanValue()) {
                    z2 = true;
                    break loop0;
                }
            }
        }
        if (z2 || isFinishing()) {
            return;
        }
        try {
            super.onBackPressed();
        } catch (Exception e) {
            if (!(e instanceof IllegalArgumentException) && !(e instanceof IllegalStateException)) {
                throw e;
            }
        }
    }
}
