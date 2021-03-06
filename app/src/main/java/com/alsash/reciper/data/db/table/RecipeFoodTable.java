package com.alsash.reciper.data.db.table;

import org.greenrobot.greendao.DaoException;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Unique;

import java.util.Date;

/**
 * A model of the Ingredient entity
 * represented by a to-many relation model of the Recipe and the Food entities,
 * that persists in local relational database table by GreenDao framework
 * and serialized from JSON by Gson framework
 */
@Entity(
        nameInDb = "RECIPE_FOOD",
        active = true
)
public final class RecipeFoodTable implements Table {
    @Id
    Long id;
    @Unique
    String uuid;
    @Index
    Date changedAt;
    @Index(name = "RECIPE_TO_FOOD")
    String recipeUuid;
    @Index(name = "FOOD_TO_RECIPE")
    String foodUuid;
    String name;
    double weight;
    String weightUnit;
    /**
     * Used to resolve relations
     */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /**
     * Used for active entity operations.
     */
    @Generated(hash = 805032546)
    private transient RecipeFoodTableDao myDao;

    @Generated(hash = 1962229842)
    public RecipeFoodTable(Long id, String uuid, Date changedAt, String recipeUuid,
                           String foodUuid, String name, double weight, String weightUnit) {
        this.id = id;
        this.uuid = uuid;
        this.changedAt = changedAt;
        this.recipeUuid = recipeUuid;
        this.foodUuid = foodUuid;
        this.name = name;
        this.weight = weight;
        this.weightUnit = weightUnit;
    }

    @Generated(hash = 74732698)
    public RecipeFoodTable() {
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

    public String getRecipeUuid() {
        return this.recipeUuid;
    }

    public void setRecipeUuid(String recipeUuid) {
        this.recipeUuid = recipeUuid;
    }

    public String getFoodUuid() {
        return this.foodUuid;
    }

    public void setFoodUuid(String foodUuid) {
        this.foodUuid = foodUuid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return this.weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getWeightUnit() {
        return this.weightUnit;
    }

    public void setWeightUnit(String weightUnit) {
        this.weightUnit = weightUnit;
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
    @Generated(hash = 2007437163)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getRecipeFoodTableDao() : null;
    }
}