package com.tazkiyatech.utils.lang;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * A container object which may or may not contain a non-null value.
 * <p>
 * This class is an alternative for the <a href="https://developer.android.com/reference/java/util/Optional.html">java.util.Optional</a> class
 * to be used in projects that have a minimum Android SDK version lower than API level 24.
 * (The <a href="https://developer.android.com/reference/java/util/Optional.html">java.util.Optional</a> class was added to Android in API level 24
 * and thus is not available in earlier versions).
 *
 * @param <T> the type of value that is held.
 * @see <a href="https://developer.android.com/reference/java/util/Optional.html">https://developer.android.com/reference/java/util/Optional.html</a>
 */
public class Optional<T> {

    @Nullable
    private final T value;

    /**
     * Returns an empty {@link Optional} instance. No value is present for this {@link Optional}.
     */
    @NonNull
    public static <T> Optional<T> empty() {
        return new Optional<>(null);
    }

    /**
     * Returns an {@link Optional} with the specified present non-null value.
     */
    @NonNull
    public static <T> Optional<T> of(@NonNull T value) {
        return new Optional<>(value);
    }

    /**
     * Returns an {@link Optional} describing the specified value, if non-null, otherwise returns an empty {@link Optional}.
     */
    @NonNull
    public static <T> Optional<T> ofNullable(@Nullable T value) {
        if (value == null) {
            return empty();
        } else {
            return of(value);
        }
    }

    /**
     * Constructor.
     */
    private Optional(@Nullable T value) {
        this.value = value;
    }

    /**
     * Returns true if the value held by this {@link Optional} is non-null, otherwise false.
     */
    public boolean isPresent() {
        return value != null;
    }

    /**
     * If a value is present in this {@link Optional}, returns the value,
     * otherwise throws {@link NoSuchElementException}.
     *
     * @return the value held by this {@link Optional}.
     * @throws NoSuchElementException if the value held by this {@link Optional} is null.
     */
    @NonNull
    public T get() throws NoSuchElementException {
        if (value == null) {
            throw new NoSuchElementException("There is no value to get from this Optional");
        } else {
            return value;
        }
    }

    /**
     * Returns the value if present, otherwise returns {@code other}.
     *
     * @param other the value to be returned if there is no value present, may be null.
     * @return the value, if present, otherwise {@code other}.
     */
    @Nullable
    public T orElse(@Nullable T other) {
        if (value == null) {
            return other;
        } else {
            return value;
        }
    }

    /**
     * Returns the contained value, if present, otherwise throws the provided exception.
     *
     * @param throwable the exception to throw if there is no value present.
     * @return the present value.
     */
    @NonNull
    public <X extends Throwable> T orElseThrow(@NonNull X throwable) throws X {
        if (value == null) {
            throw throwable;
        } else {
            return value;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Optional)) {
            return false;
        }
        Optional<?> other = (Optional<?>) obj;
        return Objects.equals(value, other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return value != null
                ? String.format("Optional[%s]", value)
                : "Optional.empty";
    }
}