package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
        StringBuilder sbU = outline.U("TransitionValues@");
        sbU.append(Integer.toHexString(hashCode()));
        sbU.append(":\n");
        StringBuilder sbX = outline.X(sbU.toString(), "    view = ");
        sbX.append(this.view);
        sbX.append("\n");
        String strW = outline.w(sbX.toString(), "    values:");
        for (String str : this.values.keySet()) {
            strW = strW + "    " + str + ": " + this.values.get(str) + "\n";
        }
        return strW;
    }

    public TransitionValues(@NonNull View view) {
        this.view = view;
    }
}
