alter table medicos drop index UQ_email_telefone;

alter table medicos add constraint UQ_telefone_email_crm UNIQUE(telefone, email, crm);