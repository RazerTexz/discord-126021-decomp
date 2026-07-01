package com.discord.widgets.guilds.invite;

import android.content.Context;
import androidx.core.view.PointerIconCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.view.LifecycleOwner;
import androidx.view.LifecycleOwner2;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventStatus;
import com.discord.api.permission.Permission;
import com.discord.app.AppFragment;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelInvite;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreStream;
import com.discord.utilities.captcha.CaptchaHelper;
import com.discord.utilities.channel.ChannelSelector;
import com.discord.utilities.coroutines.AppCoroutineScope;
import com.discord.utilities.coroutines.RxCoroutineExtensions;
import com.discord.utilities.error.AppCancellationException;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.guilds.GuildCaptchaUtils;
import com.discord.utilities.guilds.MemberVerificationUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.TextInVoiceFeatureFlag;
import com.discord.widgets.guilds.join.InviteArgs;
import com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventDetailsBottomSheet;
import com.discord.widgets.hubs.WidgetHubEmailFlow;
import com.discord.widgets.hubs.WidgetHubEmailViewModel2;
import com.discord.widgets.hubs.WidgetHubEmailViewModel3;
import com.discord.widgets.stage.StageChannelJoinHelper;
import com.discord.widgets.voice.fullscreen.WidgetCallPreviewFullscreen;
import com.discord.widgets.voice.sheet.WidgetVoiceBottomSheet;
import d0.Result3;
import d0.w.SafeContinuationJvm;
import d0.w.h.Intrinsics2;
import d0.w.h.IntrinsicsJvm;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.w.i.a.DebugProbes;
import d0.w.i.a.boxing;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;
import retrofit2.HttpException;
import rx.Observable;

/* JADX INFO: compiled from: InviteJoinHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteJoinHelper {
    public static final InviteJoinHelper INSTANCE = new InviteJoinHelper();

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$1, reason: invalid class name */
    /* JADX INFO: compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$1", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<Error, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Error error, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(error, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$2, reason: invalid class name */
    /* JADX INFO: compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$2", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass2 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass2(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass2(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$3, reason: invalid class name */
    /* JADX INFO: compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$3", f = "InviteJoinHelper.kt", l = {}, m = "invokeSuspend")
    public static final class AnonymousClass3 extends ContinuationImpl6 implements Function2<ModelInvite, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass3(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(ModelInvite modelInvite, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(modelInvite, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Intrinsics2.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Result3.throwOnFailure(obj);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$4, reason: invalid class name */
    /* JADX INFO: compiled from: InviteJoinHelper.kt */
    @DebugMetadata(c = "com.discord.widgets.guilds.invite.InviteJoinHelper$joinViaInvite$4", f = "InviteJoinHelper.kt", l = {79, 104, 117, 118, Opcodes.IINC, Opcodes.LOOKUPSWITCH, 200}, m = "invokeSuspend")
    public static final class AnonymousClass4 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ CaptchaHelper.CaptchaPayload $captchaPayload;
        public final /* synthetic */ AppFragment $fragment;
        public final /* synthetic */ ModelInvite $invite;
        public final /* synthetic */ Class $javaClass;
        public final /* synthetic */ String $location;
        public final /* synthetic */ Function2 $onInviteFlowFinished;
        public final /* synthetic */ Function2 $onInvitePostError;
        public final /* synthetic */ Function2 $onInvitePostSuccess;
        public Object L$0;
        public Object L$1;
        public Object L$2;
        public Object L$3;
        public int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(AppFragment appFragment, ModelInvite modelInvite, String str, Function2 function2, CaptchaHelper.CaptchaPayload captchaPayload, Class cls, Function2 function3, Function2 function4, Continuation continuation) {
            super(2, continuation);
            this.$fragment = appFragment;
            this.$invite = modelInvite;
            this.$location = str;
            this.$onInvitePostSuccess = function2;
            this.$captchaPayload = captchaPayload;
            this.$javaClass = cls;
            this.$onInvitePostError = function3;
            this.$onInviteFlowFinished = function4;
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return new AnonymousClass4(this.$fragment, this.$invite, this.$location, this.$onInvitePostSuccess, this.$captchaPayload, this.$javaClass, this.$onInvitePostError, this.$onInviteFlowFinished, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass4) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        /* JADX WARN: Code duplicated, block: B:100:0x0211  */
        /* JADX WARN: Code duplicated, block: B:103:0x023a A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:107:0x024d A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:108:0x024e  */
        /* JADX WARN: Code duplicated, block: B:117:0x0285  */
        /* JADX WARN: Code duplicated, block: B:119:0x0290  */
        /* JADX WARN: Code duplicated, block: B:121:0x02aa  */
        /* JADX WARN: Code duplicated, block: B:124:0x02c4  */
        /* JADX WARN: Code duplicated, block: B:126:0x02c7  */
        /* JADX WARN: Code duplicated, block: B:127:0x02c9  */
        /* JADX WARN: Code duplicated, block: B:130:0x02d0  */
        /* JADX WARN: Code duplicated, block: B:131:0x02d7  */
        /* JADX WARN: Code duplicated, block: B:134:0x02df  */
        /* JADX WARN: Code duplicated, block: B:136:0x02e3  */
        /* JADX WARN: Code duplicated, block: B:139:0x02f2  */
        /* JADX WARN: Code duplicated, block: B:143:0x02f9  */
        /* JADX WARN: Code duplicated, block: B:145:0x0301  */
        /* JADX WARN: Code duplicated, block: B:147:0x0309  */
        /* JADX WARN: Code duplicated, block: B:148:0x030e  */
        /* JADX WARN: Code duplicated, block: B:151:0x0313  */
        /* JADX WARN: Code duplicated, block: B:152:0x031c  */
        /* JADX WARN: Code duplicated, block: B:154:0x0324  */
        /* JADX WARN: Code duplicated, block: B:165:0x0370  */
        /* JADX WARN: Code duplicated, block: B:166:0x037e  */
        /* JADX WARN: Code duplicated, block: B:167:0x0386  */
        /* JADX WARN: Code duplicated, block: B:169:0x038e  */
        /* JADX WARN: Code duplicated, block: B:174:0x03ac A[ADDED_TO_REGION, REMOVE] */
        /* JADX WARN: Code duplicated, block: B:175:0x03ba  */
        /* JADX WARN: Code duplicated, block: B:179:0x03d2  */
        /* JADX WARN: Code duplicated, block: B:182:0x03e5 A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:75:0x01a1  */
        /* JADX WARN: Code duplicated, block: B:83:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:85:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:86:0x01d4  */
        /* JADX WARN: Code duplicated, block: B:88:0x01d7  */
        /* JADX WARN: Code duplicated, block: B:90:0x01ec A[RETURN] */
        /* JADX WARN: Code duplicated, block: B:91:0x01ed  */
        /* JADX WARN: Code duplicated, block: B:93:0x01f2 A[Catch: AppCancellationException -> 0x0053, TRY_ENTER, TryCatch #0 {AppCancellationException -> 0x0053, blocks: (B:10:0x003d, B:13:0x004c, B:104:0x023b, B:93:0x01f2, B:95:0x0202, B:97:0x0208, B:99:0x020c, B:101:0x0212), top: B:194:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:95:0x0202 A[Catch: AppCancellationException -> 0x0053, TryCatch #0 {AppCancellationException -> 0x0053, blocks: (B:10:0x003d, B:13:0x004c, B:104:0x023b, B:93:0x01f2, B:95:0x0202, B:97:0x0208, B:99:0x020c, B:101:0x0212), top: B:194:0x000b }] */
        /* JADX WARN: Code duplicated, block: B:96:0x0207  */
        /* JADX WARN: Code duplicated, block: B:99:0x020c A[Catch: AppCancellationException -> 0x0053, TryCatch #0 {AppCancellationException -> 0x0053, blocks: (B:10:0x003d, B:13:0x004c, B:104:0x023b, B:93:0x01f2, B:95:0x0202, B:97:0x0208, B:99:0x020c, B:101:0x0212), top: B:194:0x000b }] */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [T, android.content.Context] */
        /* JADX WARN: Type inference failed for: r7v15, types: [T, androidx.fragment.app.FragmentManager, java.lang.Object] */
        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Ref$ObjectRef ref$ObjectRef;
            ModelInvite modelInvite;
            Channel channel;
            boolean zBooleanValue;
            Guild guild;
            long jLongValue;
            Channel channel2;
            Channel channel3;
            Object orThrow;
            GuildScheduledEvent guildScheduledEvent;
            GuildScheduledEventStatus status;
            Long lBoxLong;
            boolean z2;
            Boolean boolBoxBoolean;
            Long l;
            boolean zBooleanValue2;
            Boolean boolBoxBoolean2;
            Ref$ObjectRef ref$ObjectRef2;
            ModelInvite modelInvite2;
            Function2 function2;
            ModelInvite modelInvite3;
            Object orThrow2;
            Long lBoxLong2;
            List<GuildFeature> listM;
            List<GuildFeature> listM2;
            List<GuildFeature> listM3;
            Guild guild2;
            com.discord.models.guild.Guild guild3;
            boolean z3;
            CaptchaHelper.CaptchaPayload captchaPayload;
            String captchaKey;
            CaptchaHelper.CaptchaPayload captchaPayload2;
            String captchaRqtoken;
            Object objAppAwaitSingle;
            Function2 function3;
            ModelInvite modelInvite4;
            Ref$ObjectRef ref$ObjectRef3;
            Long lBoxLong3;
            ModelInvite modelInvite5;
            Function2 function4;
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            try {
                switch (this.label) {
                    case 0:
                        Result3.throwOnFailure(obj);
                        Ref$ObjectRef ref$ObjectRef4 = new Ref$ObjectRef();
                        ref$ObjectRef4.element = this.$fragment.requireContext();
                        Ref$ObjectRef ref$ObjectRef5 = new Ref$ObjectRef();
                        ?? parentFragmentManager = this.$fragment.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "fragment.parentFragmentManager");
                        ref$ObjectRef5.element = parentFragmentManager;
                        Guild guild4 = this.$invite.guild;
                        boolean z4 = (guild4 == null || (listM3 = guild4.m()) == null || !listM3.contains(GuildFeature.MEMBER_VERIFICATION_GATE_ENABLED)) ? false : true;
                        Guild guild5 = this.$invite.guild;
                        boolean z5 = (guild5 == null || (listM2 = guild5.m()) == null || listM2.contains(GuildFeature.PREVIEW_ENABLED)) ? false : true;
                        Guild guild6 = this.$invite.guild;
                        boolean z6 = (guild6 == null || (listM = guild6.m()) == null || !listM.contains(GuildFeature.HUB)) ? false : true;
                        if (z6 && !GrowthTeamFeatures.INSTANCE.isHubEnabled()) {
                            AppToast.g((Context) ref$ObjectRef4.element, R.string.discord_u_coming_soon_to_mobile, 0, null, 12);
                        } else if (z6 && GrowthTeamFeatures.INSTANCE.isHubEmailConnectionEnabled()) {
                            Context context = (Context) ref$ObjectRef4.element;
                            WidgetHubEmailViewModel3 widgetHubEmailViewModel3 = WidgetHubEmailViewModel3.Invite;
                            Guild guild7 = this.$invite.guild;
                            String name = guild7 != null ? guild7.getName() : null;
                            if (name == null) {
                                name = "";
                            }
                            AppScreen2.d(context, WidgetHubEmailFlow.class, new WidgetHubEmailViewModel2(name, this.$invite.getApproximateMemberCount(), widgetHubEmailViewModel3));
                            FragmentActivity fragmentActivityE = this.$fragment.e();
                            if (fragmentActivityE != null) {
                                fragmentActivityE.onBackPressed();
                            }
                        } else {
                            if (z4 && z5) {
                                this.L$0 = ref$ObjectRef4;
                                this.L$1 = ref$ObjectRef5;
                                this.L$2 = null;
                                this.L$3 = this;
                                this.label = 1;
                                SafeContinuationJvm safeContinuationJvm = new SafeContinuationJvm(IntrinsicsJvm.intercepted(this));
                                MemberVerificationUtils memberVerificationUtils = MemberVerificationUtils.INSTANCE;
                                Context context2 = (Context) ref$ObjectRef4.element;
                                Guild guild8 = this.$invite.guild;
                                memberVerificationUtils.maybeShowVerificationGate(context2, (FragmentManager) ref$ObjectRef5.element, (guild8 == null || (lBoxLong2 = boxing.boxLong(guild8.getId())) == null) ? -1L : lBoxLong2.longValue(), this.$location, this.$invite, new InviteJoinHelper2(safeContinuationJvm), new InviteJoinHelper3(safeContinuationJvm));
                                orThrow2 = safeContinuationJvm.getOrThrow();
                                if (orThrow2 == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                                    DebugProbes.probeCoroutineSuspended(this);
                                }
                                if (orThrow2 == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ref$ObjectRef2 = ref$ObjectRef4;
                                modelInvite3 = null;
                                if (!((Boolean) orThrow2).booleanValue()) {
                                    return Unit.a;
                                }
                            } else {
                                ref$ObjectRef2 = ref$ObjectRef4;
                                modelInvite3 = null;
                            }
                            guild2 = this.$invite.guild;
                            if (guild2 != null || (lBoxLong3 = boxing.boxLong(guild2.getId())) == null) {
                                guild3 = null;
                            } else {
                                guild3 = StoreStream.INSTANCE.getGuilds().getGuilds().get(boxing.boxLong(lBoxLong3.longValue()));
                            }
                            if (guild3 != null) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (z3) {
                                function3 = this.$onInvitePostSuccess;
                                modelInvite4 = this.$invite;
                                this.L$0 = ref$ObjectRef2;
                                this.L$1 = modelInvite3;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 2;
                                if (function3.invoke(modelInvite4, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                modelInvite = modelInvite3;
                                ref$ObjectRef3 = ref$ObjectRef2;
                                ref$ObjectRef = ref$ObjectRef3;
                                channel = this.$invite.getChannel();
                                if (channel != null) {
                                    Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                                    if (ChannelUtils.w(channel)) {
                                        l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                        if (l != null || (boolBoxBoolean2 = boxing.boxBoolean(PermissionUtils.can(Permission.CONNECT, boxing.boxLong(l.longValue())))) == null) {
                                            zBooleanValue2 = false;
                                        } else {
                                            zBooleanValue2 = boolBoxBoolean2.booleanValue();
                                        }
                                        if (zBooleanValue2) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    boolBoxBoolean = boxing.boxBoolean(z2);
                                    if (boolBoxBoolean != null) {
                                        zBooleanValue = boolBoxBoolean.booleanValue();
                                    } else {
                                        zBooleanValue = false;
                                    }
                                } else {
                                    zBooleanValue = false;
                                }
                                guild = this.$invite.guild;
                                if (guild == null) {
                                    ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                                } else {
                                    if (guild != null || (lBoxLong = boxing.boxLong(guild.getId())) == null) {
                                        jLongValue = 0;
                                    } else {
                                        jLongValue = lBoxLong.longValue();
                                    }
                                    if (jLongValue <= 0) {
                                        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                                    } else if (this.$invite.getGuildScheduledEvent() == null) {
                                        channel2 = this.$invite.getChannel();
                                        if (channel2 != null || !ChannelUtils.J(channel2)) {
                                            channel3 = this.$invite.getChannel();
                                            if (channel3 == null && ChannelUtils.D(channel3) && !zBooleanValue) {
                                                InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                            } else {
                                                InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                            }
                                        } else if (zBooleanValue) {
                                            this.L$0 = ref$ObjectRef;
                                            this.L$1 = modelInvite;
                                            this.L$2 = this;
                                            this.L$3 = null;
                                            this.label = 6;
                                            SafeContinuationJvm safeContinuationJvm2 = new SafeContinuationJvm(IntrinsicsJvm.intercepted(this));
                                            this.$fragment.requestMicrophone(new InviteJoinHelper4(safeContinuationJvm2), new InviteJoinHelper5(safeContinuationJvm2));
                                            orThrow = safeContinuationJvm2.getOrThrow();
                                            if (orThrow == Intrinsics2.getCOROUTINE_SUSPENDED()) {
                                                DebugProbes.probeCoroutineSuspended(this);
                                            }
                                            if (orThrow == coroutine_suspended) {
                                                return coroutine_suspended;
                                            }
                                            if (((Boolean) orThrow).booleanValue()) {
                                                InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                            } else {
                                                InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                            }
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                        }
                                    } else {
                                        guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                        if (guildScheduledEvent != null) {
                                            status = guildScheduledEvent.getStatus();
                                        } else {
                                            status = null;
                                        }
                                        if (status != GuildScheduledEventStatus.ACTIVE) {
                                            InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                        } else {
                                            channel2 = this.$invite.getChannel();
                                            if (channel2 != null) {
                                                channel3 = this.$invite.getChannel();
                                                if (channel3 == null) {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                } else {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                }
                                            } else {
                                                channel3 = this.$invite.getChannel();
                                                if (channel3 == null) {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                } else {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                }
                                            }
                                        }
                                    }
                                }
                                function2 = this.$onInviteFlowFinished;
                                if (modelInvite == null) {
                                    modelInvite = this.$invite;
                                }
                                this.L$0 = null;
                                this.L$1 = null;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 7;
                                if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            } else {
                                RestAPI api = RestAPI.INSTANCE.getApi();
                                ModelInvite modelInvite6 = this.$invite;
                                String str = this.$location;
                                captchaPayload = this.$captchaPayload;
                                if (captchaPayload != null) {
                                    captchaKey = captchaPayload.getCaptchaKey();
                                } else {
                                    captchaKey = null;
                                }
                                captchaPayload2 = this.$captchaPayload;
                                if (captchaPayload2 != null) {
                                    captchaRqtoken = captchaPayload2.getCaptchaRqtoken();
                                } else {
                                    captchaRqtoken = null;
                                }
                                Observable observableUi = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(api.postInviteCode(modelInvite6, str, new RestAPIParams.InviteCode(captchaKey, captchaRqtoken)), false, 1, null));
                                Context context3 = (Context) ref$ObjectRef2.element;
                                Boolean boolBoxBoolean3 = boxing.boxBoolean(true);
                                this.L$0 = ref$ObjectRef2;
                                this.L$1 = modelInvite3;
                                this.L$2 = null;
                                this.L$3 = null;
                                this.label = 3;
                                objAppAwaitSingle = RxCoroutineExtensions.appAwaitSingle(observableUi, context3, boolBoxBoolean3, this);
                                if (objAppAwaitSingle == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                modelInvite5 = (ModelInvite) objAppAwaitSingle;
                                try {
                                    function4 = this.$onInvitePostSuccess;
                                    this.L$0 = ref$ObjectRef2;
                                    this.L$1 = modelInvite5;
                                    this.label = 4;
                                    if (function4.invoke(modelInvite5, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    modelInvite2 = modelInvite5;
                                    modelInvite = modelInvite2;
                                    ref$ObjectRef = ref$ObjectRef2;
                                    channel = this.$invite.getChannel();
                                    if (channel != null) {
                                        Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                                        if (ChannelUtils.w(channel)) {
                                            z2 = false;
                                        } else {
                                            l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                            if (l != null) {
                                                zBooleanValue2 = false;
                                            } else {
                                                zBooleanValue2 = false;
                                            }
                                            if (zBooleanValue2) {
                                                z2 = true;
                                            } else {
                                                z2 = false;
                                            }
                                        }
                                        boolBoxBoolean = boxing.boxBoolean(z2);
                                        if (boolBoxBoolean != null) {
                                            zBooleanValue = boolBoxBoolean.booleanValue();
                                        } else {
                                            zBooleanValue = false;
                                        }
                                    } else {
                                        zBooleanValue = false;
                                    }
                                    guild = this.$invite.guild;
                                    if (guild == null) {
                                        ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                                    } else {
                                        if (guild != null) {
                                            jLongValue = 0;
                                        } else {
                                            jLongValue = 0;
                                        }
                                        if (jLongValue <= 0) {
                                            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                                        } else if (this.$invite.getGuildScheduledEvent() == null) {
                                            channel2 = this.$invite.getChannel();
                                            if (channel2 != null) {
                                                channel3 = this.$invite.getChannel();
                                                if (channel3 == null) {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                } else {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                }
                                            } else {
                                                channel3 = this.$invite.getChannel();
                                                if (channel3 == null) {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                } else {
                                                    InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                }
                                            }
                                        } else {
                                            guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                            if (guildScheduledEvent != null) {
                                                status = guildScheduledEvent.getStatus();
                                            } else {
                                                status = null;
                                            }
                                            if (status != GuildScheduledEventStatus.ACTIVE) {
                                                InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                            } else {
                                                channel2 = this.$invite.getChannel();
                                                if (channel2 != null) {
                                                    channel3 = this.$invite.getChannel();
                                                    if (channel3 == null) {
                                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                    } else {
                                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                    }
                                                } else {
                                                    channel3 = this.$invite.getChannel();
                                                    if (channel3 == null) {
                                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                    } else {
                                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    function2 = this.$onInviteFlowFinished;
                                    if (modelInvite == null) {
                                        modelInvite = this.$invite;
                                    }
                                    this.L$0 = null;
                                    this.L$1 = null;
                                    this.L$2 = null;
                                    this.L$3 = null;
                                    this.label = 7;
                                    if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                } catch (AppCancellationException e) {
                                    e = e;
                                    modelInvite2 = modelInvite5;
                                    Throwable cause = e.getCause();
                                    if (!(cause instanceof HttpException)) {
                                        Function2 function5 = this.$onInvitePostError;
                                        Error errorCreate = cause != null ? Error.create(cause) : null;
                                        this.L$0 = null;
                                        this.L$1 = null;
                                        this.L$2 = null;
                                        this.L$3 = null;
                                        this.label = 5;
                                        if (function5.invoke(errorCreate, this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                        return Unit.a;
                                    }
                                    GuildCaptchaUtils.handleHttpException(e.getError(), this.$fragment, new InviteArgs(this.$invite, this.$javaClass, this.$location, this.$onInvitePostError, this.$onInvitePostSuccess, this.$onInviteFlowFinished));
                                }
                            }
                        }
                        return Unit.a;
                    case 1:
                        ModelInvite modelInvite7 = (ModelInvite) this.L$2;
                        Ref$ObjectRef ref$ObjectRef6 = (Ref$ObjectRef) this.L$0;
                        Result3.throwOnFailure(obj);
                        ref$ObjectRef2 = ref$ObjectRef6;
                        modelInvite3 = modelInvite7;
                        orThrow2 = obj;
                        if (!((Boolean) orThrow2).booleanValue()) {
                            return Unit.a;
                        }
                        guild2 = this.$invite.guild;
                        if (guild2 != null) {
                            guild3 = null;
                        } else {
                            guild3 = null;
                        }
                        if (guild3 != null) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (z3) {
                            function3 = this.$onInvitePostSuccess;
                            modelInvite4 = this.$invite;
                            this.L$0 = ref$ObjectRef2;
                            this.L$1 = modelInvite3;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 2;
                            if (function3.invoke(modelInvite4, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            modelInvite = modelInvite3;
                            ref$ObjectRef3 = ref$ObjectRef2;
                            ref$ObjectRef = ref$ObjectRef3;
                            channel = this.$invite.getChannel();
                            if (channel != null) {
                                Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                                if (ChannelUtils.w(channel)) {
                                    z2 = false;
                                } else {
                                    l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                    if (l != null) {
                                        zBooleanValue2 = false;
                                    } else {
                                        zBooleanValue2 = false;
                                    }
                                    if (zBooleanValue2) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                }
                                boolBoxBoolean = boxing.boxBoolean(z2);
                                if (boolBoxBoolean != null) {
                                    zBooleanValue = boolBoxBoolean.booleanValue();
                                } else {
                                    zBooleanValue = false;
                                }
                            } else {
                                zBooleanValue = false;
                            }
                            guild = this.$invite.guild;
                            if (guild == null) {
                                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                            } else {
                                if (guild != null) {
                                    jLongValue = 0;
                                } else {
                                    jLongValue = 0;
                                }
                                if (jLongValue <= 0) {
                                    ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                                } else if (this.$invite.getGuildScheduledEvent() == null) {
                                    channel2 = this.$invite.getChannel();
                                    if (channel2 != null) {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    } else {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    }
                                } else {
                                    guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                    if (guildScheduledEvent != null) {
                                        status = guildScheduledEvent.getStatus();
                                    } else {
                                        status = null;
                                    }
                                    if (status != GuildScheduledEventStatus.ACTIVE) {
                                        InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                    } else {
                                        channel2 = this.$invite.getChannel();
                                        if (channel2 != null) {
                                            channel3 = this.$invite.getChannel();
                                            if (channel3 == null) {
                                                InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                            } else {
                                                InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                            }
                                        } else {
                                            channel3 = this.$invite.getChannel();
                                            if (channel3 == null) {
                                                InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                            } else {
                                                InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                            }
                                        }
                                    }
                                }
                            }
                            function2 = this.$onInviteFlowFinished;
                            if (modelInvite == null) {
                                modelInvite = this.$invite;
                            }
                            this.L$0 = null;
                            this.L$1 = null;
                            this.L$2 = null;
                            this.L$3 = null;
                            this.label = 7;
                            if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            return Unit.a;
                        }
                        RestAPI api2 = RestAPI.INSTANCE.getApi();
                        ModelInvite modelInvite8 = this.$invite;
                        String str2 = this.$location;
                        captchaPayload = this.$captchaPayload;
                        if (captchaPayload != null) {
                            captchaKey = captchaPayload.getCaptchaKey();
                        } else {
                            captchaKey = null;
                        }
                        captchaPayload2 = this.$captchaPayload;
                        if (captchaPayload2 != null) {
                            captchaRqtoken = captchaPayload2.getCaptchaRqtoken();
                        } else {
                            captchaRqtoken = null;
                        }
                        Observable observableUi2 = ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn$default(api2.postInviteCode(modelInvite8, str2, new RestAPIParams.InviteCode(captchaKey, captchaRqtoken)), false, 1, null));
                        Context context4 = (Context) ref$ObjectRef2.element;
                        Boolean boolBoxBoolean4 = boxing.boxBoolean(true);
                        this.L$0 = ref$ObjectRef2;
                        this.L$1 = modelInvite3;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 3;
                        objAppAwaitSingle = RxCoroutineExtensions.appAwaitSingle(observableUi2, context4, boolBoxBoolean4, this);
                        if (objAppAwaitSingle == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        modelInvite5 = (ModelInvite) objAppAwaitSingle;
                        function4 = this.$onInvitePostSuccess;
                        this.L$0 = ref$ObjectRef2;
                        this.L$1 = modelInvite5;
                        this.label = 4;
                        if (function4.invoke(modelInvite5, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        modelInvite2 = modelInvite5;
                        modelInvite = modelInvite2;
                        ref$ObjectRef = ref$ObjectRef2;
                        channel = this.$invite.getChannel();
                        if (channel != null) {
                            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                            if (ChannelUtils.w(channel)) {
                                z2 = false;
                            } else {
                                l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                if (l != null) {
                                    zBooleanValue2 = false;
                                } else {
                                    zBooleanValue2 = false;
                                }
                                if (zBooleanValue2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            boolBoxBoolean = boxing.boxBoolean(z2);
                            if (boolBoxBoolean != null) {
                                zBooleanValue = boolBoxBoolean.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        } else {
                            zBooleanValue = false;
                        }
                        guild = this.$invite.guild;
                        if (guild == null) {
                            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                        } else {
                            if (guild != null) {
                                jLongValue = 0;
                            } else {
                                jLongValue = 0;
                            }
                            if (jLongValue <= 0) {
                                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                            } else if (this.$invite.getGuildScheduledEvent() == null) {
                                channel2 = this.$invite.getChannel();
                                if (channel2 != null) {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                } else {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                }
                            } else {
                                guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                if (guildScheduledEvent != null) {
                                    status = guildScheduledEvent.getStatus();
                                } else {
                                    status = null;
                                }
                                if (status != GuildScheduledEventStatus.ACTIVE) {
                                    InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                } else {
                                    channel2 = this.$invite.getChannel();
                                    if (channel2 != null) {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    } else {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    }
                                }
                            }
                        }
                        function2 = this.$onInviteFlowFinished;
                        if (modelInvite == null) {
                            modelInvite = this.$invite;
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.a;
                    case 2:
                        modelInvite = (ModelInvite) this.L$1;
                        ref$ObjectRef3 = (Ref$ObjectRef) this.L$0;
                        Result3.throwOnFailure(obj);
                        ref$ObjectRef = ref$ObjectRef3;
                        channel = this.$invite.getChannel();
                        if (channel != null) {
                            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                            if (ChannelUtils.w(channel)) {
                                z2 = false;
                            } else {
                                l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                if (l != null) {
                                    zBooleanValue2 = false;
                                } else {
                                    zBooleanValue2 = false;
                                }
                                if (zBooleanValue2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            boolBoxBoolean = boxing.boxBoolean(z2);
                            if (boolBoxBoolean != null) {
                                zBooleanValue = boolBoxBoolean.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        } else {
                            zBooleanValue = false;
                        }
                        guild = this.$invite.guild;
                        if (guild == null) {
                            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                        } else {
                            if (guild != null) {
                                jLongValue = 0;
                            } else {
                                jLongValue = 0;
                            }
                            if (jLongValue <= 0) {
                                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                            } else if (this.$invite.getGuildScheduledEvent() == null) {
                                channel2 = this.$invite.getChannel();
                                if (channel2 != null) {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                } else {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                }
                            } else {
                                guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                if (guildScheduledEvent != null) {
                                    status = guildScheduledEvent.getStatus();
                                } else {
                                    status = null;
                                }
                                if (status != GuildScheduledEventStatus.ACTIVE) {
                                    InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                } else {
                                    channel2 = this.$invite.getChannel();
                                    if (channel2 != null) {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    } else {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    }
                                }
                            }
                        }
                        function2 = this.$onInviteFlowFinished;
                        if (modelInvite == null) {
                            modelInvite = this.$invite;
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.a;
                    case 3:
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                        Result3.throwOnFailure(obj);
                        objAppAwaitSingle = obj;
                        modelInvite5 = (ModelInvite) objAppAwaitSingle;
                        function4 = this.$onInvitePostSuccess;
                        this.L$0 = ref$ObjectRef2;
                        this.L$1 = modelInvite5;
                        this.label = 4;
                        if (function4.invoke(modelInvite5, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        modelInvite2 = modelInvite5;
                        modelInvite = modelInvite2;
                        ref$ObjectRef = ref$ObjectRef2;
                        channel = this.$invite.getChannel();
                        if (channel != null) {
                            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                            if (ChannelUtils.w(channel)) {
                                z2 = false;
                            } else {
                                l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                if (l != null) {
                                    zBooleanValue2 = false;
                                } else {
                                    zBooleanValue2 = false;
                                }
                                if (zBooleanValue2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            boolBoxBoolean = boxing.boxBoolean(z2);
                            if (boolBoxBoolean != null) {
                                zBooleanValue = boolBoxBoolean.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        } else {
                            zBooleanValue = false;
                        }
                        guild = this.$invite.guild;
                        if (guild == null) {
                            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                        } else {
                            if (guild != null) {
                                jLongValue = 0;
                            } else {
                                jLongValue = 0;
                            }
                            if (jLongValue <= 0) {
                                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                            } else if (this.$invite.getGuildScheduledEvent() == null) {
                                channel2 = this.$invite.getChannel();
                                if (channel2 != null) {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                } else {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                }
                            } else {
                                guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                if (guildScheduledEvent != null) {
                                    status = guildScheduledEvent.getStatus();
                                } else {
                                    status = null;
                                }
                                if (status != GuildScheduledEventStatus.ACTIVE) {
                                    InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                } else {
                                    channel2 = this.$invite.getChannel();
                                    if (channel2 != null) {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    } else {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    }
                                }
                            }
                        }
                        function2 = this.$onInviteFlowFinished;
                        if (modelInvite == null) {
                            modelInvite = this.$invite;
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.a;
                    case 4:
                        modelInvite2 = (ModelInvite) this.L$1;
                        ref$ObjectRef2 = (Ref$ObjectRef) this.L$0;
                        Result3.throwOnFailure(obj);
                        modelInvite = modelInvite2;
                        ref$ObjectRef = ref$ObjectRef2;
                        channel = this.$invite.getChannel();
                        if (channel != null) {
                            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
                            if (ChannelUtils.w(channel)) {
                                z2 = false;
                            } else {
                                l = StoreStream.INSTANCE.getPermissions().getPermissionsByChannel().get(boxing.boxLong(channel.getId()));
                                if (l != null) {
                                    zBooleanValue2 = false;
                                } else {
                                    zBooleanValue2 = false;
                                }
                                if (zBooleanValue2) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            }
                            boolBoxBoolean = boxing.boxBoolean(z2);
                            if (boolBoxBoolean != null) {
                                zBooleanValue = boolBoxBoolean.booleanValue();
                            } else {
                                zBooleanValue = false;
                            }
                        } else {
                            zBooleanValue = false;
                        }
                        guild = this.$invite.guild;
                        if (guild == null) {
                            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                        } else {
                            if (guild != null) {
                                jLongValue = 0;
                            } else {
                                jLongValue = 0;
                            }
                            if (jLongValue <= 0) {
                                ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), this.$invite.getChannel(), null, null, 6, null);
                            } else if (this.$invite.getGuildScheduledEvent() == null) {
                                channel2 = this.$invite.getChannel();
                                if (channel2 != null) {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                } else {
                                    channel3 = this.$invite.getChannel();
                                    if (channel3 == null) {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    } else {
                                        InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                    }
                                }
                            } else {
                                guildScheduledEvent = this.$invite.getGuildScheduledEvent();
                                if (guildScheduledEvent != null) {
                                    status = guildScheduledEvent.getStatus();
                                } else {
                                    status = null;
                                }
                                if (status != GuildScheduledEventStatus.ACTIVE) {
                                    InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                                } else {
                                    channel2 = this.$invite.getChannel();
                                    if (channel2 != null) {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    } else {
                                        channel3 = this.$invite.getChannel();
                                        if (channel3 == null) {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        } else {
                                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                                        }
                                    }
                                }
                            }
                        }
                        function2 = this.$onInviteFlowFinished;
                        if (modelInvite == null) {
                            modelInvite = this.$invite;
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.a;
                    case 5:
                        Result3.throwOnFailure(obj);
                        return Unit.a;
                    case 6:
                        modelInvite = (ModelInvite) this.L$1;
                        ref$ObjectRef = (Ref$ObjectRef) this.L$0;
                        Result3.throwOnFailure(obj);
                        orThrow = obj;
                        if (((Boolean) orThrow).booleanValue()) {
                            InviteJoinHelper.INSTANCE.navigateToChannel((Context) ref$ObjectRef.element, this.$fragment, this.$invite);
                        } else {
                            InviteJoinHelper.INSTANCE.navigateToGuild(this.$invite);
                        }
                        function2 = this.$onInviteFlowFinished;
                        if (modelInvite == null) {
                            modelInvite = this.$invite;
                        }
                        this.L$0 = null;
                        this.L$1 = null;
                        this.L$2 = null;
                        this.L$3 = null;
                        this.label = 7;
                        if (function2.invoke(modelInvite, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        return Unit.a;
                    case 7:
                        Result3.throwOnFailure(obj);
                        return Unit.a;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            } catch (AppCancellationException e2) {
                e = e2;
            }
        }
    }

    private InviteJoinHelper() {
    }

    private final void navigateToChannel(Context context, AppFragment appFragment, ModelInvite modelInvite) {
        Channel channel = modelInvite.getChannel();
        if (channel != null) {
            ChannelSelector.INSTANCE.getInstance().findAndSet(context, channel.getId());
            Intrinsics3.checkNotNullExpressionValue(channel, "channel");
            if (ChannelUtils.J(channel)) {
                if (TextInVoiceFeatureFlag.INSTANCE.getINSTANCE().isEnabled(Long.valueOf(channel.getGuildId()))) {
                    WidgetCallPreviewFullscreen.Companion.launch$default(WidgetCallPreviewFullscreen.INSTANCE, context, channel.getId(), null, 4, null);
                    return;
                }
                WidgetVoiceBottomSheet.Companion companion = WidgetVoiceBottomSheet.INSTANCE;
                FragmentManager parentFragmentManager = appFragment.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "appFragment.parentFragmentManager");
                companion.show(parentFragmentManager, channel.getId(), true, WidgetVoiceBottomSheet.FeatureContext.HOME);
                return;
            }
            if (ChannelUtils.D(channel)) {
                StageChannelJoinHelper stageChannelJoinHelper = StageChannelJoinHelper.INSTANCE;
                Context contextRequireContext = appFragment.requireContext();
                FragmentManager parentFragmentManager2 = appFragment.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "appFragment.parentFragmentManager");
                StageChannelJoinHelper.connectToStage$default(stageChannelJoinHelper, contextRequireContext, parentFragmentManager2, channel.getId(), false, false, null, null, null, null, null, PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW, null);
            }
        }
    }

    private final void navigateToGuild(ModelInvite modelInvite) {
        Guild guild = modelInvite.guild;
        if (guild != null) {
            StoreStream.INSTANCE.getGuildSelected().set(guild.getId());
        }
        GuildScheduledEvent guildScheduledEvent = modelInvite.getGuildScheduledEvent();
        if (guildScheduledEvent != null) {
            WidgetGuildScheduledEventDetailsBottomSheet.INSTANCE.enqueue(guildScheduledEvent.getId());
        }
    }

    public final Job joinViaInvite(ModelInvite invite, Class<?> javaClass, AppFragment fragment, String location, Function2<? super Error, ? super Continuation<? super Unit>, ? extends Object> onInvitePostError, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInvitePostSuccess, Function2<? super ModelInvite, ? super Continuation<? super Unit>, ? extends Object> onInviteFlowFinished, CaptchaHelper.CaptchaPayload captchaPayload) {
        Intrinsics3.checkNotNullParameter(invite, "invite");
        Intrinsics3.checkNotNullParameter(javaClass, "javaClass");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Intrinsics3.checkNotNullParameter(location, ModelAuditLogEntry.CHANGE_KEY_LOCATION);
        Intrinsics3.checkNotNullParameter(onInvitePostError, "onInvitePostError");
        Intrinsics3.checkNotNullParameter(onInvitePostSuccess, "onInvitePostSuccess");
        Intrinsics3.checkNotNullParameter(onInviteFlowFinished, "onInviteFlowFinished");
        LifecycleOwner viewLifecycleOwner = fragment.getViewLifecycleOwner();
        Intrinsics3.checkNotNullExpressionValue(viewLifecycleOwner, "fragment.viewLifecycleOwner");
        return AppCoroutineScope.appLaunch$default(LifecycleOwner2.getLifecycleScope(viewLifecycleOwner), javaClass, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass4(fragment, invite, location, onInvitePostSuccess, captchaPayload, javaClass, onInvitePostError, onInviteFlowFinished, null), 6, (Object) null);
    }
}
