package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import b.d.b.a.a;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater$DeclaredOnClickListener implements View$OnClickListener {
    private final View mHostView;
    private final String mMethodName;
    private Context mResolvedContext;
    private Method mResolvedMethod;

    public AppCompatViewInflater$DeclaredOnClickListener(@NonNull View view, @NonNull String str) {
        this.mHostView = view;
        this.mMethodName = str;
    }

    private void resolveMethod(@Nullable Context context) {
        String string;
        Method method;
        while (context != null) {
            try {
                if (!context.isRestricted() && (method = context.getClass().getMethod(this.mMethodName, View.class)) != null) {
                    this.mResolvedMethod = method;
                    this.mResolvedContext = context;
                    return;
                }
            } catch (NoSuchMethodException unused) {
            }
            context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
        }
        int id2 = this.mHostView.getId();
        if (id2 == -1) {
            string = "";
        } else {
            StringBuilder sbU = a.U(" with id '");
            sbU.append(this.mHostView.getContext().getResources().getResourceEntryName(id2));
            sbU.append("'");
            string = sbU.toString();
        }
        StringBuilder sbU2 = a.U("Could not find method ");
        sbU2.append(this.mMethodName);
        sbU2.append("(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
        sbU2.append(this.mHostView.getClass());
        sbU2.append(string);
        throw new IllegalStateException(sbU2.toString());
    }

    @Override // android.view.View$OnClickListener
    public void onClick(@NonNull View view) {
        if (this.mResolvedMethod == null) {
            resolveMethod(this.mHostView.getContext());
        }
        try {
            this.mResolvedMethod.invoke(this.mResolvedContext, view);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        } catch (InvocationTargetException e2) {
            throw new IllegalStateException("Could not execute method for android:onClick", e2);
        }
    }
}
