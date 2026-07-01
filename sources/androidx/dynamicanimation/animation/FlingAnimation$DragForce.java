package androidx.dynamicanimation.animation;

/* JADX INFO: loaded from: classes.dex */
public final class FlingAnimation$DragForce implements Force {
    private static final float DEFAULT_FRICTION = -4.2f;
    private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
    private float mFriction = DEFAULT_FRICTION;
    private final DynamicAnimation$MassState mMassState = new DynamicAnimation$MassState();
    private float mVelocityThreshold;

    @Override // androidx.dynamicanimation.animation.Force
    public float getAcceleration(float f, float f2) {
        return f2 * this.mFriction;
    }

    public float getFrictionScalar() {
        return this.mFriction / DEFAULT_FRICTION;
    }

    @Override // androidx.dynamicanimation.animation.Force
    public boolean isAtEquilibrium(float f, float f2) {
        return Math.abs(f2) < this.mVelocityThreshold;
    }

    public void setFrictionScalar(float f) {
        this.mFriction = f * DEFAULT_FRICTION;
    }

    public void setValueThreshold(float f) {
        this.mVelocityThreshold = f * VELOCITY_THRESHOLD_MULTIPLIER;
    }

    public DynamicAnimation$MassState updateValueAndVelocity(float f, float f2, long j) {
        float f3 = j;
        this.mMassState.mVelocity = (float) (Math.exp((f3 / 1000.0f) * this.mFriction) * ((double) f2));
        DynamicAnimation$MassState dynamicAnimation$MassState = this.mMassState;
        float f4 = this.mFriction;
        dynamicAnimation$MassState.mValue = (float) ((Math.exp((f4 * f3) / 1000.0f) * ((double) (f2 / f4))) + ((double) (f - (f2 / f4))));
        DynamicAnimation$MassState dynamicAnimation$MassState2 = this.mMassState;
        if (isAtEquilibrium(dynamicAnimation$MassState2.mValue, dynamicAnimation$MassState2.mVelocity)) {
            this.mMassState.mVelocity = 0.0f;
        }
        return this.mMassState;
    }
}
