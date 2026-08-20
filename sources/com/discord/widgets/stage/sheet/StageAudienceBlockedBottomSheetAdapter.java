package com.discord.widgets.stage.sheet;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.databinding.StageAudienceBlockedBottomSheetHeaderItemBinding;
import com.discord.databinding.StageAudienceBlockedBottomSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.user.User;
import com.discord.stores.StoreVoiceParticipants;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.views.CutoutView;
import com.discord.widgets.user.UserNameFormatterKt;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.textview.MaterialTextView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StageAudienceBlockedBottomSheetAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_PARTICIPANT = 1;

    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<StageAudienceBlockedBottomSheetAdapter, MGRecyclerDataPayload> {
        private final StageAudienceBlockedBottomSheetHeaderItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter) {
            super(C5419R.layout.stage_audience_blocked_bottom_sheet_header_item, stageAudienceBlockedBottomSheetAdapter);
            C12238m.checkNotNullParameter(stageAudienceBlockedBottomSheetAdapter, "adapter");
            View view = this.itemView;
            int i = C5419R.id.description;
            MaterialTextView materialTextView = (MaterialTextView) view.findViewById(C5419R.id.description);
            if (materialTextView != null) {
                i = C5419R.id.title;
                MaterialTextView materialTextView2 = (MaterialTextView) view.findViewById(C5419R.id.title);
                if (materialTextView2 != null) {
                    StageAudienceBlockedBottomSheetHeaderItemBinding stageAudienceBlockedBottomSheetHeaderItemBinding = new StageAudienceBlockedBottomSheetHeaderItemBinding((ConstraintLayout) view, materialTextView, materialTextView2);
                    C12238m.checkNotNullExpressionValue(stageAudienceBlockedBottomSheetHeaderItemBinding, "StageAudienceBlockedBott…temBinding.bind(itemView)");
                    this.binding = stageAudienceBlockedBottomSheetHeaderItemBinding;
                    return;
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Header) {
                MaterialTextView materialTextView = this.binding.f15244c;
                C12238m.checkNotNullExpressionValue(materialTextView, "binding.title");
                ListItem.Header header = (ListItem.Header) data;
                materialTextView.setText(C1107b.m216h(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.string.stage_blocked_users_title_plural, new Object[]{StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.stage_blocked_users_title_plural_number, header.getNumBlockedUsers(), new Object[0])}, null, 4));
                MaterialTextView materialTextView2 = this.binding.f15243b;
                C12238m.checkNotNullExpressionValue(materialTextView2, "binding.description");
                materialTextView2.setText(C1107b.m216h(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.string.stage_blocked_users_body, new Object[]{StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.stage_blocked_users_body_number, header.getNumBlockedUsers(), Integer.valueOf(header.getNumBlockedUsers()))}, null, 4));
            }
        }
    }

    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
    public static abstract class ListItem implements MGRecyclerDataPayload {

        /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
        public static final /* data */ class Header extends ListItem {
            private final String key;
            private final int numBlockedUsers;
            private final int type;

            public Header(int i) {
                super(null);
                this.numBlockedUsers = i;
                this.key = "AudienceBlockedHeader";
            }

            public static /* synthetic */ Header copy$default(Header header, int i, int i2, Object obj) {
                if ((i2 & 1) != 0) {
                    i = header.numBlockedUsers;
                }
                return header.copy(i);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final int getNumBlockedUsers() {
                return this.numBlockedUsers;
            }

            public final Header copy(int numBlockedUsers) {
                return new Header(numBlockedUsers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Header) && this.numBlockedUsers == ((Header) other).numBlockedUsers;
                }
                return true;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final int getNumBlockedUsers() {
                return this.numBlockedUsers;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            public int hashCode() {
                return this.numBlockedUsers;
            }

            public String toString() {
                return C1643a.m814B(C1643a.m833U("Header(numBlockedUsers="), this.numBlockedUsers, ")");
            }
        }

        /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
        public static final /* data */ class Participant extends ListItem {
            private final boolean isSpeaker;
            private final String key;
            private final StoreVoiceParticipants.VoiceUser participant;
            private final int type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Participant(StoreVoiceParticipants.VoiceUser voiceUser, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(voiceUser, "participant");
                this.participant = voiceUser;
                this.isSpeaker = z2;
                this.type = 1;
                this.key = String.valueOf(voiceUser.getUser().getId());
            }

            public static /* synthetic */ Participant copy$default(Participant participant, StoreVoiceParticipants.VoiceUser voiceUser, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    voiceUser = participant.participant;
                }
                if ((i & 2) != 0) {
                    z2 = participant.isSpeaker;
                }
                return participant.copy(voiceUser, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsSpeaker() {
                return this.isSpeaker;
            }

            public final Participant copy(StoreVoiceParticipants.VoiceUser participant, boolean isSpeaker) {
                C12238m.checkNotNullParameter(participant, "participant");
                return new Participant(participant, isSpeaker);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Participant)) {
                    return false;
                }
                Participant participant = (Participant) other;
                return C12238m.areEqual(this.participant, participant.participant) && this.isSpeaker == participant.isSpeaker;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
            public String getKey() {
                return this.key;
            }

            public final StoreVoiceParticipants.VoiceUser getParticipant() {
                return this.participant;
            }

            @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
            public int getType() {
                return this.type;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                StoreVoiceParticipants.VoiceUser voiceUser = this.participant;
                int iHashCode = (voiceUser != null ? voiceUser.hashCode() : 0) * 31;
                boolean z2 = this.isSpeaker;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public final boolean isSpeaker() {
                return this.isSpeaker;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Participant(participant=");
                sbM833U.append(this.participant);
                sbM833U.append(", isSpeaker=");
                return C1643a.m827O(sbM833U, this.isSpeaker, ")");
            }
        }

        private ListItem() {
        }

        public /* synthetic */ ListItem(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StageAudienceBlockedBottomSheetAdapter.kt */
    public static final class ParticipantViewHolder extends MGRecyclerViewHolder<StageAudienceBlockedBottomSheetAdapter, MGRecyclerDataPayload> {
        private final StageAudienceBlockedBottomSheetItemBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ParticipantViewHolder(StageAudienceBlockedBottomSheetAdapter stageAudienceBlockedBottomSheetAdapter) {
            super(C5419R.layout.stage_audience_blocked_bottom_sheet_item, stageAudienceBlockedBottomSheetAdapter);
            C12238m.checkNotNullParameter(stageAudienceBlockedBottomSheetAdapter, "adapter");
            View view = this.itemView;
            ConstraintLayout constraintLayout = (ConstraintLayout) view;
            int i = C5419R.id.stage_channel_blocked_member_icon;
            SimpleDraweeView simpleDraweeView = (SimpleDraweeView) view.findViewById(C5419R.id.stage_channel_blocked_member_icon);
            if (simpleDraweeView != null) {
                i = C5419R.id.stage_channel_blocked_member_icon_container;
                CutoutView cutoutView = (CutoutView) view.findViewById(C5419R.id.stage_channel_blocked_member_icon_container);
                if (cutoutView != null) {
                    i = C5419R.id.stage_channel_blocked_member_name;
                    TextView textView = (TextView) view.findViewById(C5419R.id.stage_channel_blocked_member_name);
                    if (textView != null) {
                        i = C5419R.id.stage_channel_blocked_member_speaker;
                        ImageView imageView = (ImageView) view.findViewById(C5419R.id.stage_channel_blocked_member_speaker);
                        if (imageView != null) {
                            i = C5419R.id.stage_channel_blocked_text;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.stage_channel_blocked_text);
                            if (textView2 != null) {
                                i = C5419R.id.stage_channel_blocked_text_divider;
                                View viewFindViewById = view.findViewById(C5419R.id.stage_channel_blocked_text_divider);
                                if (viewFindViewById != null) {
                                    i = C5419R.id.stage_channel_blocked_text_speaker;
                                    TextView textView3 = (TextView) view.findViewById(C5419R.id.stage_channel_blocked_text_speaker);
                                    if (textView3 != null) {
                                        StageAudienceBlockedBottomSheetItemBinding stageAudienceBlockedBottomSheetItemBinding = new StageAudienceBlockedBottomSheetItemBinding((ConstraintLayout) view, constraintLayout, simpleDraweeView, cutoutView, textView, imageView, textView2, viewFindViewById, textView3);
                                        C12238m.checkNotNullExpressionValue(stageAudienceBlockedBottomSheetItemBinding, "StageAudienceBlockedBott…temBinding.bind(itemView)");
                                        this.binding = stageAudienceBlockedBottomSheetItemBinding;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, MGRecyclerDataPayload data) {
            C12238m.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            if (data instanceof ListItem.Participant) {
                ListItem.Participant participant = (ListItem.Participant) data;
                this.binding.f15247c.setCutoutEnabled(participant.isSpeaker());
                ImageView imageView = this.binding.f15249e;
                imageView.setBackgroundResource(C5419R.drawable.drawable_uikit_white_circle);
                imageView.setImageResource(C5419R.drawable.ic_mic_grey_24dp);
                imageView.setVisibility(participant.isSpeaker() ? 0 : 4);
                imageView.setActivated(participant.isSpeaker());
                View view = this.itemView;
                C12238m.checkNotNullExpressionValue(view, "itemView");
                Resources resources = view.getResources();
                TextView textView = this.binding.f15250f;
                C12238m.checkNotNullExpressionValue(textView, "binding.stageChannelBlockedTextSpeaker");
                textView.setText(participant.isSpeaker() ? resources.getString(C5419R.string.stage_speaker) : resources.getString(C5419R.string.stage_audience));
                TextView textView2 = this.binding.f15248d;
                User user = participant.getParticipant().getUser();
                String nickname = participant.getParticipant().getNickname();
                Context context = textView2.getContext();
                C12238m.checkNotNullExpressionValue(context, "context");
                textView2.setText(UserNameFormatterKt.getSpannableForUserNameWithDiscrim(user, nickname, context, C5419R.attr.colorHeaderPrimary, C5419R.attr.font_primary_semibold, C5419R.integer.uikit_textsize_large_sp, C5419R.attr.colorTextMuted, C5419R.attr.font_primary_normal, C5419R.integer.uikit_textsize_medium_sp));
                SimpleDraweeView simpleDraweeView = this.binding.f15246b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView, "binding.stageChannelBlockedMemberIcon");
                IconUtils.setIcon$default(simpleDraweeView, participant.getParticipant().getUser().getUsername(), Long.valueOf(participant.getParticipant().getUser().getId()), participant.getParticipant().getUser().getAvatar(), Integer.valueOf(C5419R.dimen.avatar_size_large), 0, null, null, participant.getParticipant().getGuildMember(), 224, null);
                SimpleDraweeView simpleDraweeView2 = this.binding.f15246b;
                C12238m.checkNotNullExpressionValue(simpleDraweeView2, "binding.stageChannelBlockedMemberIcon");
                simpleDraweeView2.setAlpha(0.5f);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StageAudienceBlockedBottomSheetAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        C12238m.checkNotNullParameter(recyclerView, "recyclerView");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple, androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return position != 0 ? 1 : 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        C12238m.checkNotNullParameter(parent, "parent");
        if (viewType == 0) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 1) {
            return new ParticipantViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
