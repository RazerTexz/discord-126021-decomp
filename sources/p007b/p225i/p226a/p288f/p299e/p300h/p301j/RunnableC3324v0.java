package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

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
import p007b.p225i.p226a.p288f.p299e.C3260e;
import p007b.p225i.p226a.p288f.p299e.p304k.C3365l;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.v0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3324v0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final C3318s0 f9460j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ AbstractDialogInterfaceOnCancelListenerC3320t0 f9461k;

    public RunnableC3324v0(AbstractDialogInterfaceOnCancelListenerC3320t0 abstractDialogInterfaceOnCancelListenerC3320t0, C3318s0 c3318s0) {
        this.f9461k = abstractDialogInterfaceOnCancelListenerC3320t0;
        this.f9460j = c3318s0;
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
        if (this.f9461k.f9451k) {
            ConnectionResult connectionResult = this.f9460j.f9449b;
            if (connectionResult.m9019w0()) {
                AbstractDialogInterfaceOnCancelListenerC3320t0 abstractDialogInterfaceOnCancelListenerC3320t0 = this.f9461k;
                InterfaceC3299j interfaceC3299j = abstractDialogInterfaceOnCancelListenerC3320t0.f20511j;
                Activity activityM9040b = abstractDialogInterfaceOnCancelListenerC3320t0.m9040b();
                PendingIntent pendingIntent = connectionResult.f20475m;
                Objects.requireNonNull(pendingIntent, "null reference");
                int i = this.f9460j.f9448a;
                int i2 = GoogleApiActivity.f20485j;
                Intent intent = new Intent(activityM9040b, (Class<?>) GoogleApiActivity.class);
                intent.putExtra("pending_intent", pendingIntent);
                intent.putExtra("failing_client_id", i);
                intent.putExtra("notify_manager", false);
                interfaceC3299j.startActivityForResult(intent, 1);
                return;
            }
            if (this.f9461k.f9454n.m9025d(connectionResult.f20474l)) {
                AbstractDialogInterfaceOnCancelListenerC3320t0 abstractDialogInterfaceOnCancelListenerC3320t1 = this.f9461k;
                GoogleApiAvailability googleApiAvailability = abstractDialogInterfaceOnCancelListenerC3320t1.f9454n;
                Activity activityM9040b2 = abstractDialogInterfaceOnCancelListenerC3320t1.m9040b();
                AbstractDialogInterfaceOnCancelListenerC3320t0 abstractDialogInterfaceOnCancelListenerC3320t2 = this.f9461k;
                googleApiAvailability.m9029j(activityM9040b2, abstractDialogInterfaceOnCancelListenerC3320t2.f20511j, connectionResult.f20474l, abstractDialogInterfaceOnCancelListenerC3320t2);
                return;
            }
            if (connectionResult.f20474l != 18) {
                this.f9461k.mo4062l(connectionResult, this.f9460j.f9448a);
                return;
            }
            Activity activityM9040b3 = this.f9461k.m9040b();
            AbstractDialogInterfaceOnCancelListenerC3320t0 abstractDialogInterfaceOnCancelListenerC3320t3 = this.f9461k;
            ProgressBar progressBar = new ProgressBar(activityM9040b3, null, R.attr.progressBarStyleLarge);
            progressBar.setIndeterminate(true);
            progressBar.setVisibility(0);
            AlertDialog.Builder builder = new AlertDialog.Builder(activityM9040b3);
            builder.setView(progressBar);
            builder.setMessage(C3365l.m4170e(activityM9040b3, 18));
            builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
            AlertDialog alertDialogCreate = builder.create();
            GoogleApiAvailability.m9023h(activityM9040b3, alertDialogCreate, "GooglePlayServicesUpdatingDialog", abstractDialogInterfaceOnCancelListenerC3320t3);
            AbstractDialogInterfaceOnCancelListenerC3320t0 abstractDialogInterfaceOnCancelListenerC3320t4 = this.f9461k;
            GoogleApiAvailability googleApiAvailability2 = abstractDialogInterfaceOnCancelListenerC3320t4.f9454n;
            Context applicationContext = abstractDialogInterfaceOnCancelListenerC3320t4.m9040b().getApplicationContext();
            C3322u0 c3322u0 = new C3322u0(this, alertDialogCreate);
            Objects.requireNonNull(googleApiAvailability2);
            IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
            intentFilter.addDataScheme("package");
            C3276a0 c3276a0 = new C3276a0(c3322u0);
            applicationContext.registerReceiver(c3276a0, intentFilter);
            c3276a0.f9341a = applicationContext;
            if (C3260e.m4020b(applicationContext, "com.google.android.gms")) {
                return;
            }
            this.f9461k.m4118m();
            if (alertDialogCreate.isShowing()) {
                alertDialogCreate.dismiss();
            }
            c3276a0.m4056a();
        }
    }
}
