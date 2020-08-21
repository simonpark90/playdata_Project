drop table word;
drop sequence seq_word;

create table word (
	num number not null,
	content long not null,
	writedate date);
CREATE SEQUENCE seq_word START WITH 1 INCREMENT BY 1 ; 

commit;
