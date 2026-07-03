package p000;

import android.view.View;
import com.lytefast.flexinput.adapters.AttachmentPreviewAdapter;
import com.lytefast.flexinput.model.Attachment;

/* JADX INFO: renamed from: e */
/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class ViewOnClickListenerC12252e implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ int f25293j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Object f25294k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ Object f25295l;

    public ViewOnClickListenerC12252e(int i, Object obj, Object obj2) {
        this.f25293j = i;
        this.f25294k = obj;
        this.f25295l = obj2;
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
    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f25293j;
        if (i == 0) {
            ((AttachmentPreviewAdapter.C11172b) this.f25294k).f22020r.selectionAggregator.unselectItem((Attachment) this.f25295l);
            return;
        }
        if (i == 1) {
            AttachmentPreviewAdapter.C11172b c11172b = (AttachmentPreviewAdapter.C11172b) this.f25294k;
            c11172b.f22019q.invoke(c11172b.f22020r.selectionAggregator, (Attachment) this.f25295l);
        } else {
            if (i != 2) {
                throw null;
            }
            ((AttachmentPreviewAdapter.C11172b) this.f25294k).f22020r.selectionAggregator.unselectItem((Attachment) this.f25295l);
        }
    }
}
