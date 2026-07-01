package b.i.a.f.e.h.j;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.widget.ProgressBar;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiActivity;
import java.util.Objects;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class v0 implements Runnable {
    public final s0 j;
    public final /* synthetic */ t0 k;

    public v0(t0 t0Var, s0 s0Var) {
        this.k = t0Var;
        this.j = s0Var;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (this.k.k) {
            ConnectionResult connectionResult = this.j.f1372b;
            if (connectionResult.w0()) {
                t0 t0Var = this.k;
                j jVar = t0Var.j;
                Activity activityB = t0Var.b();
                PendingIntent pendingIntent = connectionResult.m;
                Objects.requireNonNull(pendingIntent, "null reference");
                int i = this.j.a;
                int i2 = GoogleApiActivity.j;
                Intent intent = new Intent(activityB, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntent);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", false);
                jVar.startActivityForResult(intent, 1);
                return;
            }
            if (this.k.n.d(connectionResult.l)) {
                t0 t0Var2 = this.k;
                GoogleApiAvailability googleApiAvailability = t0Var2.n;
                Activity activityB2 = t0Var2.b();
                t0 t0Var3 = this.k;
                googleApiAvailability.j(activityB2, t0Var3.j, connectionResult.l, t0Var3);
                return;
            }
            if (connectionResult.l != 18) {
                this.k.l(connectionResult, this.j.a);
                return;
            }
            Activity activityB3 = this.k.b();
            t0 t0Var4 = this.k;
            ProgressBar progressBar = new ProgressBar(activityB3, null, R.attr.progressBarStyleLarge);
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            AlertDialog.Builder builder = new AlertDialog.Builder(activityB3);
            builder.setView(progressBar);
            builder.setMessage(b.i.a.f.e.k.l.e(activityB3, 18));
            builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
            AlertDialog alertDialogCreate = builder.create();
            GoogleApiAvailability.h(activityB3, alertDialogCreate, "GooglePlayServicesUpdatingDialog", t0Var4);
            t0 t0Var5 = this.k;
            GoogleApiAvailability googleApiAvailability2 = t0Var5.n;
            Context applicationContext = t0Var5.b().getApplicationContext();
            u0 u0Var = new u0(this, alertDialogCreate);
            Objects.requireNonNull(googleApiAvailability2);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            a0 a0Var = new a0(u0Var);
            applicationContext.registerReceiver(a0Var, intentFilter);
            a0Var.a = applicationContext;
            if (b.i.a.f.e.e.b(applicationContext, "com.google.android.gms")) {
                return;
            }
            this.k.m();
            if (alertDialogCreate.isShowing()) {
                alertDialogCreate.dismiss();
            }
            a0Var.a();
        }
    }
}
