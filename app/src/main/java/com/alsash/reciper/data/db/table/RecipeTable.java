package com.alsash.reciper.data.db.table;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;

/**
 * A model of the Recipe entity
 * that persists in local relational database table by GreenDao framework
 * and serialized from JSON by Gson framework
 */
@Entity(
        nameInDb = "RECIPE",
        active = true
)
public final class RecipeTable implements Table {
    @Id
    Long id;
    @Unique
    String uuid;
    @Index
    Date changedAt;
    @SerializedName("created_at_unix")
    Date createdAt;
    String name;
    String source;
    String description;
    @NotNull
    boolean bookmark;
    @NotNull
    int servings;
    @NotNull
    double massFlowRateGps; // gram per second
    @Index(name = "CATEGORY_TO_RECIPE")
    String categoryUuid;
    @Index(name = "AUTHOR_TO_RECIPE")
    String authorUuid;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 1210201788)
    private transient RecipeTableDao myDao;

    @Generated(hash = 1782286148)
    public RecipeTable(Long id, String uuid, Date changedAt, Date createdAt,
                       String name, String source, String description, boolean bookmark,
                       int servings, double massFlowRateGps, String categoryUuid,
                       String authorUuid) {
        this.id = id;
        this.uuid = uuid;
        this.changedAt = changedAt;
        this.createdAt = createdAt;
        this.name = name;
        this.source = source;
        this.description = description;
        this.bookmark = bookmark;
        this.servings = servings;
        this.massFlowRateGps = massFlowRateGps;
        this.categoryUuid = categoryUuid;
        this.authorUuid = authorUuid;
    }

    @Generated(hash = 1656289545)
    public RecipeTable() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUuid() {
        return this.uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getChangedAt() {
        return this.changedAt;
    }

    public void setChangedAt(Date changedAt) {
        this.changedAt = changedAt;
    }

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return this.source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getBookmark() {
        return this.bookmark;
    }

    public void setBookmark(boolean bookmark) {
        this.bookmark = bookmark;
    }

    public int getServings() {
        return this.servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public double getMassFlowRateGps() {
        return this.massFlowRateGps;
    }

    public void setMassFlowRateGps(double massFlowRateGps) {
        this.massFlowRateGps = massFlowRateGps;
    }

    public String getCategoryUuid() {
        return this.categoryUuid;
    }

    public void setCategoryUuid(String categoryUuid) {
        this.categoryUuid = categoryUuid;
    }

    public String getAuthorUuid() {
        return this.authorUuid;
    }

    public void setAuthorUuid(String authorUuid) {
        this.authorUuid = authorUuid;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /**
     * called by internal mechanisms, do not call yourself.
     */
    @Generated(hash = 173120018)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRecipeTableDao() : null;
    }
}