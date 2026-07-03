package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: loaded from: classes.dex */
public class TransitionValues {
    public View view;
    public final Map<String, Object> values = new HashMap();
    public final ArrayList<Transition> mTargetedTransitions = new ArrayList<>();

    @Deprecated
    public TransitionValues() {
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TransitionValues)) {
            return false;
        }
        TransitionValues transitionValues = (TransitionValues) obj;
        return this.view == transitionValues.view && this.values.equals(transitionValues.values);
    }

    public int hashCode() {
        return this.values.hashCode() + (this.view.hashCode() * 31);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("TransitionValues@");
        sbM833U.append(Integer.toHexString(hashCode()));
        sbM833U.append(":\n");
        StringBuilder sbM836X = C1643a.m836X(sbM833U.toString(), "    view = ");
        sbM836X.append(this.view);
        sbM836X.append("\n");
        String strM883w = C1643a.m883w(sbM836X.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strM883w = strM883w + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strM883w;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
