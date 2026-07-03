package com.discord.views.user;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.discord.C5419R;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.user.CoreUser;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.images.MGImages;
import com.discord.views.CutoutView;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p025i.C0956f4;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: UserSummaryView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserSummaryView extends ConstraintLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final CutoutView.InterfaceC7075a.c cutoutStyle;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int avatarSizePx;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public int overlapAmountPx;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public List<UserGuildMember> members;

    /* JADX INFO: renamed from: n, reason: from kotlin metadata */
    public int maxAvatars;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserSummaryView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        C12238m.checkNotNullParameter(context, "context");
        this.cutoutStyle = new CutoutView.InterfaceC7075a.c(0);
        Resources resources = getResources();
        C12238m.checkNotNullExpressionValue(resources, "resources");
        this.avatarSizePx = (int) (16 * resources.getDisplayMetrics().density);
        Resources resources2 = getResources();
        C12238m.checkNotNullExpressionValue(resources2, "resources");
        this.overlapAmountPx = (int) (4 * resources2.getDisplayMetrics().density);
        this.members = C12147n.emptyList();
        this.maxAvatars = 3;
        int[] iArr = C5419R.a.UserSummaryView;
        C12238m.checkNotNullExpressionValue(iArr, "R.styleable.UserSummaryView");
        Context context2 = getContext();
        C12238m.checkNotNullExpressionValue(context2, "context");
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr);
        C12238m.checkNotNullExpressionValue(typedArrayObtainStyledAttributes, "obtainStyledAttributes(attrs, styleable)");
        this.avatarSizePx = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, this.avatarSizePx);
        this.overlapAmountPx = typedArrayObtainStyledAttributes.getDimensionPixelSize(0, this.overlapAmountPx);
        this.maxAvatars = typedArrayObtainStyledAttributes.getInt(2, this.maxAvatars);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX INFO: renamed from: b */
    public static /* synthetic */ void m8623b(UserSummaryView userSummaryView, List list, boolean z2, int i) {
        if ((i & 2) != 0) {
            z2 = true;
        }
        userSummaryView.m8624a(list, z2);
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
    /* JADX INFO: renamed from: a */
    public final void m8624a(List<UserGuildMember> members, boolean withFullAvatarAtEnd) {
        int id2;
        C12238m.checkNotNullParameter(members, "members");
        if (!C12238m.areEqual(members, this.members)) {
            this.members = members;
            int iCoerceAtMost = C11226f.coerceAtMost(members.size(), this.maxAvatars);
            while (getChildCount() > iCoerceAtMost) {
                removeViewAt(getChildCount() - 1);
            }
            while (true) {
                id2 = 0;
                if (getChildCount() >= iCoerceAtMost) {
                    break;
                }
                int childCount = getChildCount();
                C0956f4 c0956f4M199a = C0956f4.m199a(LayoutInflater.from(getContext()).inflate(C5419R.layout.view_user_summary_item, (ViewGroup) this, false));
                C12238m.checkNotNullExpressionValue(c0956f4M199a, "ViewUserSummaryItemBindi…ext), this, false\n      )");
                CutoutView cutoutView = c0956f4M199a.f845a;
                cutoutView.setId(childCount + 10);
                int i = this.avatarSizePx;
                ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(i, i);
                layoutParams.topToTop = 0;
                layoutParams.bottomToBottom = 0;
                layoutParams.setMarginStart(childCount != 0 ? this.avatarSizePx - this.overlapAmountPx : 0);
                if (childCount != 0) {
                    id2 = cutoutView.getId() - 1;
                }
                layoutParams.startToStart = id2;
                cutoutView.setLayoutParams(layoutParams);
                C12238m.checkNotNullExpressionValue(cutoutView, "ViewUserSummaryItemBindi…      }\n        }\n      }");
                addView(cutoutView, cutoutView.getLayoutParams());
            }
            int i2 = iCoerceAtMost - 1;
            while (id2 < iCoerceAtMost) {
                C0956f4 c0956f4M199a2 = C0956f4.m199a(getChildAt(id2));
                C12238m.checkNotNullExpressionValue(c0956f4M199a2, "ViewUserSummaryItemBinding.bind(getChildAt(i))");
                c0956f4M199a2.f845a.setStyle((id2 == i2 && withFullAvatarAtEnd) ? CutoutView.InterfaceC7075a.d.f19062a : this.cutoutStyle);
                int mediaProxySize = IconUtils.getMediaProxySize(this.avatarSizePx);
                UserGuildMember userGuildMember = this.members.get(id2);
                String forGuildMemberOrUser$default = IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, userGuildMember.getUser(), userGuildMember.getGuildMember(), Integer.valueOf(mediaProxySize), false, 8, null);
                SimpleDraweeView simpleDraweeView = c0956f4M199a2.f846b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "cutout.avatar");
                if (!C12238m.areEqual(forGuildMemberOrUser$default, simpleDraweeView.getTag())) {
                    SimpleDraweeView simpleDraweeView2 = c0956f4M199a2.f846b;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView2, "cutout.avatar");
                    simpleDraweeView2.setTag(forGuildMemberOrUser$default);
                    SimpleDraweeView simpleDraweeView3 = c0956f4M199a2.f846b;
                    C12238m.checkNotNullExpressionValue(simpleDraweeView3, "cutout.avatar");
                    IconUtils.setIcon$default(simpleDraweeView3, forGuildMemberOrUser$default, C5419R.dimen.avatar_size_reply, (Function1) null, (MGImages.ChangeDetector) null, 24, (Object) null);
                }
                id2++;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        if (isInEditMode()) {
            int i = 2;
            String str = null;
            boolean z2 = false;
            DefaultConstructorMarker defaultConstructorMarker = null;
            m8624a(C12147n.listOf((Object[]) new UserGuildMember[]{new UserGuildMember(new CoreUser(0L, "mreynolds", null, str, false, z2, 0, null, 0, 0, null, null, 4092, defaultConstructorMarker), null, i, 0 == true ? 1 : 0), new UserGuildMember(new CoreUser(1L, "itskaylee", str, null, z2, 0 == true ? 1 : 0, 0, null, 0, 0, null, null, 4092, defaultConstructorMarker), 0 == true ? 1 : 0, i, 0 == true ? 1 : 0)}), true);
        }
    }
}
