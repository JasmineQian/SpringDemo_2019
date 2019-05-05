package com.example.demo.bean.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WebserviceLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public WebserviceLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andWlgIdIsNull() {
            addCriterion("WLG_ID is null");
            return (Criteria) this;
        }

        public Criteria andWlgIdIsNotNull() {
            addCriterion("WLG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andWlgIdEqualTo(String value) {
            addCriterion("WLG_ID =", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdNotEqualTo(String value) {
            addCriterion("WLG_ID <>", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdGreaterThan(String value) {
            addCriterion("WLG_ID >", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_ID >=", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdLessThan(String value) {
            addCriterion("WLG_ID <", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdLessThanOrEqualTo(String value) {
            addCriterion("WLG_ID <=", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdLike(String value) {
            addCriterion("WLG_ID like", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdNotLike(String value) {
            addCriterion("WLG_ID not like", value, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdIn(List<String> values) {
            addCriterion("WLG_ID in", values, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdNotIn(List<String> values) {
            addCriterion("WLG_ID not in", values, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdBetween(String value1, String value2) {
            addCriterion("WLG_ID between", value1, value2, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgIdNotBetween(String value1, String value2) {
            addCriterion("WLG_ID not between", value1, value2, "wlgId");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidIsNull() {
            addCriterion("WLG_SESSIONID is null");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidIsNotNull() {
            addCriterion("WLG_SESSIONID is not null");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidEqualTo(String value) {
            addCriterion("WLG_SESSIONID =", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidNotEqualTo(String value) {
            addCriterion("WLG_SESSIONID <>", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidGreaterThan(String value) {
            addCriterion("WLG_SESSIONID >", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_SESSIONID >=", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidLessThan(String value) {
            addCriterion("WLG_SESSIONID <", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidLessThanOrEqualTo(String value) {
            addCriterion("WLG_SESSIONID <=", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidLike(String value) {
            addCriterion("WLG_SESSIONID like", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidNotLike(String value) {
            addCriterion("WLG_SESSIONID not like", value, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidIn(List<String> values) {
            addCriterion("WLG_SESSIONID in", values, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidNotIn(List<String> values) {
            addCriterion("WLG_SESSIONID not in", values, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidBetween(String value1, String value2) {
            addCriterion("WLG_SESSIONID between", value1, value2, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgSessionidNotBetween(String value1, String value2) {
            addCriterion("WLG_SESSIONID not between", value1, value2, "wlgSessionid");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrIsNull() {
            addCriterion("WLG_REMOTEIPADDR is null");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrIsNotNull() {
            addCriterion("WLG_REMOTEIPADDR is not null");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrEqualTo(String value) {
            addCriterion("WLG_REMOTEIPADDR =", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrNotEqualTo(String value) {
            addCriterion("WLG_REMOTEIPADDR <>", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrGreaterThan(String value) {
            addCriterion("WLG_REMOTEIPADDR >", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_REMOTEIPADDR >=", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrLessThan(String value) {
            addCriterion("WLG_REMOTEIPADDR <", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrLessThanOrEqualTo(String value) {
            addCriterion("WLG_REMOTEIPADDR <=", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrLike(String value) {
            addCriterion("WLG_REMOTEIPADDR like", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrNotLike(String value) {
            addCriterion("WLG_REMOTEIPADDR not like", value, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrIn(List<String> values) {
            addCriterion("WLG_REMOTEIPADDR in", values, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrNotIn(List<String> values) {
            addCriterion("WLG_REMOTEIPADDR not in", values, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrBetween(String value1, String value2) {
            addCriterion("WLG_REMOTEIPADDR between", value1, value2, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRemoteipaddrNotBetween(String value1, String value2) {
            addCriterion("WLG_REMOTEIPADDR not between", value1, value2, "wlgRemoteipaddr");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlIsNull() {
            addCriterion("WLG_REQUESTURL is null");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlIsNotNull() {
            addCriterion("WLG_REQUESTURL is not null");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlEqualTo(String value) {
            addCriterion("WLG_REQUESTURL =", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlNotEqualTo(String value) {
            addCriterion("WLG_REQUESTURL <>", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlGreaterThan(String value) {
            addCriterion("WLG_REQUESTURL >", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_REQUESTURL >=", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlLessThan(String value) {
            addCriterion("WLG_REQUESTURL <", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlLessThanOrEqualTo(String value) {
            addCriterion("WLG_REQUESTURL <=", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlLike(String value) {
            addCriterion("WLG_REQUESTURL like", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlNotLike(String value) {
            addCriterion("WLG_REQUESTURL not like", value, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlIn(List<String> values) {
            addCriterion("WLG_REQUESTURL in", values, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlNotIn(List<String> values) {
            addCriterion("WLG_REQUESTURL not in", values, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlBetween(String value1, String value2) {
            addCriterion("WLG_REQUESTURL between", value1, value2, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgRequesturlNotBetween(String value1, String value2) {
            addCriterion("WLG_REQUESTURL not between", value1, value2, "wlgRequesturl");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtIsNull() {
            addCriterion("WLG_START_DT is null");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtIsNotNull() {
            addCriterion("WLG_START_DT is not null");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtEqualTo(Date value) {
            addCriterion("WLG_START_DT =", value, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtNotEqualTo(Date value) {
            addCriterion("WLG_START_DT <>", value, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtGreaterThan(Date value) {
            addCriterion("WLG_START_DT >", value, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtGreaterThanOrEqualTo(Date value) {
            addCriterion("WLG_START_DT >=", value, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtLessThan(Date value) {
            addCriterion("WLG_START_DT <", value, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtLessThanOrEqualTo(Date value) {
            addCriterion("WLG_START_DT <=", value, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtIn(List<Date> values) {
            addCriterion("WLG_START_DT in", values, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtNotIn(List<Date> values) {
            addCriterion("WLG_START_DT not in", values, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtBetween(Date value1, Date value2) {
            addCriterion("WLG_START_DT between", value1, value2, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgStartDtNotBetween(Date value1, Date value2) {
            addCriterion("WLG_START_DT not between", value1, value2, "wlgStartDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtIsNull() {
            addCriterion("WLG_END_DT is null");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtIsNotNull() {
            addCriterion("WLG_END_DT is not null");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtEqualTo(Date value) {
            addCriterion("WLG_END_DT =", value, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtNotEqualTo(Date value) {
            addCriterion("WLG_END_DT <>", value, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtGreaterThan(Date value) {
            addCriterion("WLG_END_DT >", value, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtGreaterThanOrEqualTo(Date value) {
            addCriterion("WLG_END_DT >=", value, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtLessThan(Date value) {
            addCriterion("WLG_END_DT <", value, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtLessThanOrEqualTo(Date value) {
            addCriterion("WLG_END_DT <=", value, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtIn(List<Date> values) {
            addCriterion("WLG_END_DT in", values, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtNotIn(List<Date> values) {
            addCriterion("WLG_END_DT not in", values, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtBetween(Date value1, Date value2) {
            addCriterion("WLG_END_DT between", value1, value2, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgEndDtNotBetween(Date value1, Date value2) {
            addCriterion("WLG_END_DT not between", value1, value2, "wlgEndDt");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostIsNull() {
            addCriterion("WLG_CLIENTHOST is null");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostIsNotNull() {
            addCriterion("WLG_CLIENTHOST is not null");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostEqualTo(String value) {
            addCriterion("WLG_CLIENTHOST =", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostNotEqualTo(String value) {
            addCriterion("WLG_CLIENTHOST <>", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostGreaterThan(String value) {
            addCriterion("WLG_CLIENTHOST >", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_CLIENTHOST >=", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostLessThan(String value) {
            addCriterion("WLG_CLIENTHOST <", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostLessThanOrEqualTo(String value) {
            addCriterion("WLG_CLIENTHOST <=", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostLike(String value) {
            addCriterion("WLG_CLIENTHOST like", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostNotLike(String value) {
            addCriterion("WLG_CLIENTHOST not like", value, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostIn(List<String> values) {
            addCriterion("WLG_CLIENTHOST in", values, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostNotIn(List<String> values) {
            addCriterion("WLG_CLIENTHOST not in", values, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostBetween(String value1, String value2) {
            addCriterion("WLG_CLIENTHOST between", value1, value2, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgClienthostNotBetween(String value1, String value2) {
            addCriterion("WLG_CLIENTHOST not between", value1, value2, "wlgClienthost");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentIsNull() {
            addCriterion("WLG_USERAGENT is null");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentIsNotNull() {
            addCriterion("WLG_USERAGENT is not null");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentEqualTo(String value) {
            addCriterion("WLG_USERAGENT =", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentNotEqualTo(String value) {
            addCriterion("WLG_USERAGENT <>", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentGreaterThan(String value) {
            addCriterion("WLG_USERAGENT >", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_USERAGENT >=", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentLessThan(String value) {
            addCriterion("WLG_USERAGENT <", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentLessThanOrEqualTo(String value) {
            addCriterion("WLG_USERAGENT <=", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentLike(String value) {
            addCriterion("WLG_USERAGENT like", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentNotLike(String value) {
            addCriterion("WLG_USERAGENT not like", value, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentIn(List<String> values) {
            addCriterion("WLG_USERAGENT in", values, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentNotIn(List<String> values) {
            addCriterion("WLG_USERAGENT not in", values, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentBetween(String value1, String value2) {
            addCriterion("WLG_USERAGENT between", value1, value2, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgUseragentNotBetween(String value1, String value2) {
            addCriterion("WLG_USERAGENT not between", value1, value2, "wlgUseragent");
            return (Criteria) this;
        }

        public Criteria andWlgMethodIsNull() {
            addCriterion("WLG_METHOD is null");
            return (Criteria) this;
        }

        public Criteria andWlgMethodIsNotNull() {
            addCriterion("WLG_METHOD is not null");
            return (Criteria) this;
        }

        public Criteria andWlgMethodEqualTo(String value) {
            addCriterion("WLG_METHOD =", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodNotEqualTo(String value) {
            addCriterion("WLG_METHOD <>", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodGreaterThan(String value) {
            addCriterion("WLG_METHOD >", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_METHOD >=", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodLessThan(String value) {
            addCriterion("WLG_METHOD <", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodLessThanOrEqualTo(String value) {
            addCriterion("WLG_METHOD <=", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodLike(String value) {
            addCriterion("WLG_METHOD like", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodNotLike(String value) {
            addCriterion("WLG_METHOD not like", value, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodIn(List<String> values) {
            addCriterion("WLG_METHOD in", values, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodNotIn(List<String> values) {
            addCriterion("WLG_METHOD not in", values, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodBetween(String value1, String value2) {
            addCriterion("WLG_METHOD between", value1, value2, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgMethodNotBetween(String value1, String value2) {
            addCriterion("WLG_METHOD not between", value1, value2, "wlgMethod");
            return (Criteria) this;
        }

        public Criteria andWlgParamsIsNull() {
            addCriterion("WLG_PARAMS is null");
            return (Criteria) this;
        }

        public Criteria andWlgParamsIsNotNull() {
            addCriterion("WLG_PARAMS is not null");
            return (Criteria) this;
        }

        public Criteria andWlgParamsEqualTo(String value) {
            addCriterion("WLG_PARAMS =", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsNotEqualTo(String value) {
            addCriterion("WLG_PARAMS <>", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsGreaterThan(String value) {
            addCriterion("WLG_PARAMS >", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_PARAMS >=", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsLessThan(String value) {
            addCriterion("WLG_PARAMS <", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsLessThanOrEqualTo(String value) {
            addCriterion("WLG_PARAMS <=", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsLike(String value) {
            addCriterion("WLG_PARAMS like", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsNotLike(String value) {
            addCriterion("WLG_PARAMS not like", value, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsIn(List<String> values) {
            addCriterion("WLG_PARAMS in", values, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsNotIn(List<String> values) {
            addCriterion("WLG_PARAMS not in", values, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsBetween(String value1, String value2) {
            addCriterion("WLG_PARAMS between", value1, value2, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsNotBetween(String value1, String value2) {
            addCriterion("WLG_PARAMS not between", value1, value2, "wlgParams");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueIsNull() {
            addCriterion("WLG_PARAMSVALUE is null");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueIsNotNull() {
            addCriterion("WLG_PARAMSVALUE is not null");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueEqualTo(String value) {
            addCriterion("WLG_PARAMSVALUE =", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueNotEqualTo(String value) {
            addCriterion("WLG_PARAMSVALUE <>", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueGreaterThan(String value) {
            addCriterion("WLG_PARAMSVALUE >", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_PARAMSVALUE >=", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueLessThan(String value) {
            addCriterion("WLG_PARAMSVALUE <", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueLessThanOrEqualTo(String value) {
            addCriterion("WLG_PARAMSVALUE <=", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueLike(String value) {
            addCriterion("WLG_PARAMSVALUE like", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueNotLike(String value) {
            addCriterion("WLG_PARAMSVALUE not like", value, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueIn(List<String> values) {
            addCriterion("WLG_PARAMSVALUE in", values, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueNotIn(List<String> values) {
            addCriterion("WLG_PARAMSVALUE not in", values, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueBetween(String value1, String value2) {
            addCriterion("WLG_PARAMSVALUE between", value1, value2, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgParamsvalueNotBetween(String value1, String value2) {
            addCriterion("WLG_PARAMSVALUE not between", value1, value2, "wlgParamsvalue");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionIsNull() {
            addCriterion("WLG_EXCEPTION is null");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionIsNotNull() {
            addCriterion("WLG_EXCEPTION is not null");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionEqualTo(String value) {
            addCriterion("WLG_EXCEPTION =", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionNotEqualTo(String value) {
            addCriterion("WLG_EXCEPTION <>", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionGreaterThan(String value) {
            addCriterion("WLG_EXCEPTION >", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_EXCEPTION >=", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionLessThan(String value) {
            addCriterion("WLG_EXCEPTION <", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionLessThanOrEqualTo(String value) {
            addCriterion("WLG_EXCEPTION <=", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionLike(String value) {
            addCriterion("WLG_EXCEPTION like", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionNotLike(String value) {
            addCriterion("WLG_EXCEPTION not like", value, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionIn(List<String> values) {
            addCriterion("WLG_EXCEPTION in", values, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionNotIn(List<String> values) {
            addCriterion("WLG_EXCEPTION not in", values, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionBetween(String value1, String value2) {
            addCriterion("WLG_EXCEPTION between", value1, value2, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgExceptionNotBetween(String value1, String value2) {
            addCriterion("WLG_EXCEPTION not between", value1, value2, "wlgException");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtIsNull() {
            addCriterion("WLG_CREATION_DT is null");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtIsNotNull() {
            addCriterion("WLG_CREATION_DT is not null");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtEqualTo(Date value) {
            addCriterion("WLG_CREATION_DT =", value, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtNotEqualTo(Date value) {
            addCriterion("WLG_CREATION_DT <>", value, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtGreaterThan(Date value) {
            addCriterion("WLG_CREATION_DT >", value, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtGreaterThanOrEqualTo(Date value) {
            addCriterion("WLG_CREATION_DT >=", value, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtLessThan(Date value) {
            addCriterion("WLG_CREATION_DT <", value, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtLessThanOrEqualTo(Date value) {
            addCriterion("WLG_CREATION_DT <=", value, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtIn(List<Date> values) {
            addCriterion("WLG_CREATION_DT in", values, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtNotIn(List<Date> values) {
            addCriterion("WLG_CREATION_DT not in", values, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtBetween(Date value1, Date value2) {
            addCriterion("WLG_CREATION_DT between", value1, value2, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationDtNotBetween(Date value1, Date value2) {
            addCriterion("WLG_CREATION_DT not between", value1, value2, "wlgCreationDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtIsNull() {
            addCriterion("WLG_UPDATE_DT is null");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtIsNotNull() {
            addCriterion("WLG_UPDATE_DT is not null");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtEqualTo(Date value) {
            addCriterion("WLG_UPDATE_DT =", value, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtNotEqualTo(Date value) {
            addCriterion("WLG_UPDATE_DT <>", value, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtGreaterThan(Date value) {
            addCriterion("WLG_UPDATE_DT >", value, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtGreaterThanOrEqualTo(Date value) {
            addCriterion("WLG_UPDATE_DT >=", value, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtLessThan(Date value) {
            addCriterion("WLG_UPDATE_DT <", value, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtLessThanOrEqualTo(Date value) {
            addCriterion("WLG_UPDATE_DT <=", value, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtIn(List<Date> values) {
            addCriterion("WLG_UPDATE_DT in", values, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtNotIn(List<Date> values) {
            addCriterion("WLG_UPDATE_DT not in", values, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtBetween(Date value1, Date value2) {
            addCriterion("WLG_UPDATE_DT between", value1, value2, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateDtNotBetween(Date value1, Date value2) {
            addCriterion("WLG_UPDATE_DT not between", value1, value2, "wlgUpdateDt");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidIsNull() {
            addCriterion("WLG_CREATIONUID is null");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidIsNotNull() {
            addCriterion("WLG_CREATIONUID is not null");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidEqualTo(String value) {
            addCriterion("WLG_CREATIONUID =", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidNotEqualTo(String value) {
            addCriterion("WLG_CREATIONUID <>", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidGreaterThan(String value) {
            addCriterion("WLG_CREATIONUID >", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_CREATIONUID >=", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidLessThan(String value) {
            addCriterion("WLG_CREATIONUID <", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidLessThanOrEqualTo(String value) {
            addCriterion("WLG_CREATIONUID <=", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidLike(String value) {
            addCriterion("WLG_CREATIONUID like", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidNotLike(String value) {
            addCriterion("WLG_CREATIONUID not like", value, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidIn(List<String> values) {
            addCriterion("WLG_CREATIONUID in", values, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidNotIn(List<String> values) {
            addCriterion("WLG_CREATIONUID not in", values, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidBetween(String value1, String value2) {
            addCriterion("WLG_CREATIONUID between", value1, value2, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgCreationuidNotBetween(String value1, String value2) {
            addCriterion("WLG_CREATIONUID not between", value1, value2, "wlgCreationuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidIsNull() {
            addCriterion("WLG_UPDATEUID is null");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidIsNotNull() {
            addCriterion("WLG_UPDATEUID is not null");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidEqualTo(String value) {
            addCriterion("WLG_UPDATEUID =", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidNotEqualTo(String value) {
            addCriterion("WLG_UPDATEUID <>", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidGreaterThan(String value) {
            addCriterion("WLG_UPDATEUID >", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_UPDATEUID >=", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidLessThan(String value) {
            addCriterion("WLG_UPDATEUID <", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidLessThanOrEqualTo(String value) {
            addCriterion("WLG_UPDATEUID <=", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidLike(String value) {
            addCriterion("WLG_UPDATEUID like", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidNotLike(String value) {
            addCriterion("WLG_UPDATEUID not like", value, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidIn(List<String> values) {
            addCriterion("WLG_UPDATEUID in", values, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidNotIn(List<String> values) {
            addCriterion("WLG_UPDATEUID not in", values, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidBetween(String value1, String value2) {
            addCriterion("WLG_UPDATEUID between", value1, value2, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgUpdateuidNotBetween(String value1, String value2) {
            addCriterion("WLG_UPDATEUID not between", value1, value2, "wlgUpdateuid");
            return (Criteria) this;
        }

        public Criteria andWlgNameIsNull() {
            addCriterion("WLG_NAME is null");
            return (Criteria) this;
        }

        public Criteria andWlgNameIsNotNull() {
            addCriterion("WLG_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andWlgNameEqualTo(String value) {
            addCriterion("WLG_NAME =", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameNotEqualTo(String value) {
            addCriterion("WLG_NAME <>", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameGreaterThan(String value) {
            addCriterion("WLG_NAME >", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_NAME >=", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameLessThan(String value) {
            addCriterion("WLG_NAME <", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameLessThanOrEqualTo(String value) {
            addCriterion("WLG_NAME <=", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameLike(String value) {
            addCriterion("WLG_NAME like", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameNotLike(String value) {
            addCriterion("WLG_NAME not like", value, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameIn(List<String> values) {
            addCriterion("WLG_NAME in", values, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameNotIn(List<String> values) {
            addCriterion("WLG_NAME not in", values, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameBetween(String value1, String value2) {
            addCriterion("WLG_NAME between", value1, value2, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgNameNotBetween(String value1, String value2) {
            addCriterion("WLG_NAME not between", value1, value2, "wlgName");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeIsNull() {
            addCriterion("WLG_RETURN_CODE is null");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeIsNotNull() {
            addCriterion("WLG_RETURN_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeEqualTo(String value) {
            addCriterion("WLG_RETURN_CODE =", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeNotEqualTo(String value) {
            addCriterion("WLG_RETURN_CODE <>", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeGreaterThan(String value) {
            addCriterion("WLG_RETURN_CODE >", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_RETURN_CODE >=", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeLessThan(String value) {
            addCriterion("WLG_RETURN_CODE <", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeLessThanOrEqualTo(String value) {
            addCriterion("WLG_RETURN_CODE <=", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeLike(String value) {
            addCriterion("WLG_RETURN_CODE like", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeNotLike(String value) {
            addCriterion("WLG_RETURN_CODE not like", value, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeIn(List<String> values) {
            addCriterion("WLG_RETURN_CODE in", values, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeNotIn(List<String> values) {
            addCriterion("WLG_RETURN_CODE not in", values, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeBetween(String value1, String value2) {
            addCriterion("WLG_RETURN_CODE between", value1, value2, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnCodeNotBetween(String value1, String value2) {
            addCriterion("WLG_RETURN_CODE not between", value1, value2, "wlgReturnCode");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageIsNull() {
            addCriterion("WLG_RETURN_MESSAGE is null");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageIsNotNull() {
            addCriterion("WLG_RETURN_MESSAGE is not null");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageEqualTo(String value) {
            addCriterion("WLG_RETURN_MESSAGE =", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageNotEqualTo(String value) {
            addCriterion("WLG_RETURN_MESSAGE <>", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageGreaterThan(String value) {
            addCriterion("WLG_RETURN_MESSAGE >", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_RETURN_MESSAGE >=", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageLessThan(String value) {
            addCriterion("WLG_RETURN_MESSAGE <", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageLessThanOrEqualTo(String value) {
            addCriterion("WLG_RETURN_MESSAGE <=", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageLike(String value) {
            addCriterion("WLG_RETURN_MESSAGE like", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageNotLike(String value) {
            addCriterion("WLG_RETURN_MESSAGE not like", value, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageIn(List<String> values) {
            addCriterion("WLG_RETURN_MESSAGE in", values, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageNotIn(List<String> values) {
            addCriterion("WLG_RETURN_MESSAGE not in", values, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageBetween(String value1, String value2) {
            addCriterion("WLG_RETURN_MESSAGE between", value1, value2, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgReturnMessageNotBetween(String value1, String value2) {
            addCriterion("WLG_RETURN_MESSAGE not between", value1, value2, "wlgReturnMessage");
            return (Criteria) this;
        }

        public Criteria andWlgSourceIsNull() {
            addCriterion("WLG_SOURCE is null");
            return (Criteria) this;
        }

        public Criteria andWlgSourceIsNotNull() {
            addCriterion("WLG_SOURCE is not null");
            return (Criteria) this;
        }

        public Criteria andWlgSourceEqualTo(String value) {
            addCriterion("WLG_SOURCE =", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceNotEqualTo(String value) {
            addCriterion("WLG_SOURCE <>", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceGreaterThan(String value) {
            addCriterion("WLG_SOURCE >", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceGreaterThanOrEqualTo(String value) {
            addCriterion("WLG_SOURCE >=", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceLessThan(String value) {
            addCriterion("WLG_SOURCE <", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceLessThanOrEqualTo(String value) {
            addCriterion("WLG_SOURCE <=", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceLike(String value) {
            addCriterion("WLG_SOURCE like", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceNotLike(String value) {
            addCriterion("WLG_SOURCE not like", value, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceIn(List<String> values) {
            addCriterion("WLG_SOURCE in", values, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceNotIn(List<String> values) {
            addCriterion("WLG_SOURCE not in", values, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceBetween(String value1, String value2) {
            addCriterion("WLG_SOURCE between", value1, value2, "wlgSource");
            return (Criteria) this;
        }

        public Criteria andWlgSourceNotBetween(String value1, String value2) {
            addCriterion("WLG_SOURCE not between", value1, value2, "wlgSource");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
