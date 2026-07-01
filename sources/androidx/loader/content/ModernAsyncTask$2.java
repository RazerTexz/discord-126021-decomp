package androidx.loader.content;

import android.os.Binder;
import android.os.Process;

/* JADX INFO: Add missing generic type declarations: [Params, Result] */
/* JADX INFO: loaded from: classes.dex */
public class ModernAsyncTask$2<Params, Result> extends ModernAsyncTask$WorkerRunnable<Params, Result> {
    public final /* synthetic */ ModernAsyncTask this$0;

    public ModernAsyncTask$2(ModernAsyncTask modernAsyncTask) {
        this.this$0 = modernAsyncTask;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.util.concurrent.Callable
    public Result call() throws Exception {
        this.this$0.mTaskInvoked.set(true);
        Result result = null;
        try {
            Process.setThreadPriority(10);
            result = (Result) this.this$0.doInBackground(this.mParams);
            Binder.flushPendingCommands();
            this.this$0.postResult(result);
            return result;
        } catch (Throwable th) {
            try {
                this.this$0.mCancelled.set(true);
                throw th;
            } catch (Throwable th2) {
                this.this$0.postResult(result);
                throw th2;
            }
        }
    }
}
