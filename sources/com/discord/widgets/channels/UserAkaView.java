package com.discord.widgets.channels;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.LeadingMarginSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.discord.R;
import com.discord.databinding.UserAkaViewBinding;
import com.discord.models.member.GuildMember;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.PileView;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: UserAkaView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class UserAkaView extends ConstraintLayout {
    private final UserAkaViewBinding binding;
    private List<GuildMember> guildMembers;
    private final StringBuilder nicknameStringBuilder;
    private List<PileView.c> pileItems;

    public UserAkaView(Context context) {
        this(context, null, 0, 6, null);
    }

    public UserAkaView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ UserAkaView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    public final void configure(final List<GuildMember> guildMembers) {
        Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
        this.guildMembers = guildMembers;
        float dimension = getResources().getDimension(R.dimen.aka_avatar_width);
        ArrayList arrayList = new ArrayList();
        for (Object obj : guildMembers) {
            if (((GuildMember) obj).hasAvatar()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String forGuildMember$default = IconUtils.getForGuildMember$default(IconUtils.INSTANCE, (GuildMember) it.next(), Integer.valueOf((int) dimension), false, 4, null);
            if (forGuildMember$default != null) {
                arrayList2.add(forGuildMember$default);
            }
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            arrayList3.add(new PileView.c(new UserAkaView2((String) it2.next()), null));
        }
        this.pileItems = arrayList3;
        this.binding.c.setItems(arrayList3);
        Intrinsics3.checkNotNullExpressionValue(OneShotPreDrawListener.add(this, new Runnable() { // from class: com.discord.widgets.channels.UserAkaView$configure$$inlined$doOnPreDraw$1
            @Override // java.lang.Runnable
            public final void run() {
                Number numberValueOf;
                List list = guildMembers;
                ArrayList arrayList4 = new ArrayList();
                Iterator it3 = list.iterator();
                while (it3.hasNext()) {
                    String nick = ((GuildMember) it3.next()).getNick();
                    if (nick != null) {
                        arrayList4.add(nick);
                    }
                }
                ArrayList arrayList5 = new ArrayList();
                for (Object obj2 : arrayList4) {
                    if (!StringsJVM.isBlank((String) obj2)) {
                        arrayList5.add(obj2);
                    }
                }
                if (this.getPileItems().isEmpty()) {
                    TextView textView = this.binding.e;
                    Intrinsics3.checkNotNullExpressionValue(textView, "binding.spaceForMeasuring");
                    numberValueOf = Float.valueOf(textView.getMeasuredWidth());
                } else {
                    numberValueOf = Integer.valueOf(DimenUtils.dpToPixels(8));
                }
                TextView textView2 = this.binding.f2162b;
                Intrinsics3.checkNotNullExpressionValue(textView2, "binding.akaText");
                float measuredWidth = textView2.getMeasuredWidth();
                PileView pileView = this.binding.c;
                Intrinsics3.checkNotNullExpressionValue(pileView, "binding.avatarsPileView");
                float fFloatValue = numberValueOf.floatValue() + measuredWidth + pileView.getMeasuredWidth();
                SpannableString spannableString = new SpannableString(_Collections.joinToString$default(arrayList5, ", ", null, null, 0, null, null, 62, null));
                spannableString.setSpan(new LeadingMarginSpan.Standard((int) fFloatValue, 0), 0, spannableString.length(), 33);
                TextView textView3 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView3, "binding.nicknames");
                textView3.setText(spannableString);
                TextView textView4 = this.binding.d;
                Intrinsics3.checkNotNullExpressionValue(textView4, "binding.nicknames");
                textView4.setVisibility(arrayList5.isEmpty() ^ true ? 0 : 8);
            }
        }), "View.doOnPreDraw(\n    crossinline action: (view: View) -> Unit\n): OneShotPreDrawListener = OneShotPreDrawListener.add(this) { action(this) }");
    }

    public final List<GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final StringBuilder getNicknameStringBuilder() {
        return this.nicknameStringBuilder;
    }

    public final List<PileView.c> getPileItems() {
        return this.pileItems;
    }

    public final void setGuildMembers(List<GuildMember> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.guildMembers = list;
    }

    public final void setPileItems(List<PileView.c> list) {
        Intrinsics3.checkNotNullParameter(list, "<set-?>");
        this.pileItems = list;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserAkaView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics3.checkNotNullParameter(context, "context");
        this.guildMembers = Collections2.emptyList();
        this.pileItems = Collections2.emptyList();
        this.nicknameStringBuilder = new StringBuilder();
        LayoutInflater.from(context).inflate(R.layout.user_aka_view, this);
        int i2 = R.id.aka_text;
        TextView textView = (TextView) findViewById(R.id.aka_text);
        if (textView != null) {
            i2 = R.id.avatars_pile_view;
            PileView pileView = (PileView) findViewById(R.id.avatars_pile_view);
            if (pileView != null) {
                i2 = R.id.nicknames;
                TextView textView2 = (TextView) findViewById(R.id.nicknames);
                if (textView2 != null) {
                    i2 = R.id.space_for_measuring;
                    TextView textView3 = (TextView) findViewById(R.id.space_for_measuring);
                    if (textView3 != null) {
                        UserAkaViewBinding userAkaViewBinding = new UserAkaViewBinding(this, textView, pileView, textView2, textView3);
                        Intrinsics3.checkNotNullExpressionValue(userAkaViewBinding, "UserAkaViewBinding.infla…ater.from(context), this)");
                        this.binding = userAkaViewBinding;
                        return;
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i2)));
    }
}
