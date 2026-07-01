package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FragmentManager$PopBackStackState implements FragmentManager$OpGenerator {
    public final int mFlags;
    public final int mId;
    public final String mName;
    public final /* synthetic */ FragmentManager this$0;

    public FragmentManager$PopBackStackState(@Nullable FragmentManager fragmentManager, String str, int i, int i2) {
        this.this$0 = fragmentManager;
        this.mName = str;
        this.mId = i;
        this.mFlags = i2;
    }

    @Override // androidx.fragment.app.FragmentManager$OpGenerator
    public boolean generateOps(@NonNull ArrayList<BackStackRecord> arrayList, @NonNull ArrayList<Boolean> arrayList2) {
        Fragment fragment = this.this$0.mPrimaryNav;
        if (fragment == null || this.mId >= 0 || this.mName != null || !fragment.getChildFragmentManager().popBackStackImmediate()) {
            return this.this$0.popBackStackState(arrayList, arrayList2, this.mName, this.mId, this.mFlags);
        }
        return false;
    }
}
